import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.japi.Pair;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.regex.Pattern;

public class ServerResult {
    static ActorRef actorSystem;
    private AsyncHttpClient httpClient = Dsl.asyncHttpClient();

 static Flow<HttpRequest, HttpResponse, NotUsed> ServerFlow (Http http, ActorSystem system, ActorMaterializer materializer ){
     actorSystem = system.actorOf(Props.create(actorSystem.class));
     return Flow
             .of(HttpRequest.class)
             .map((req)-> {
                 Map<String, String> paramsMap = req.getUri().query().toMap();
                 if (!paramsMap.containsKey("testUrl") || !paramsMap.containsKey("count")) {
                     System.out.println(paramsMap.toString());
                     return new Pair<HttpRequest, Integer>(HttpRequest.create("localhost"), 0);
                 }
                 String url = paramsMap.get("testUrl");
                 int count = Integer.parseInt(paramsMap.get("count"));
                 return new SearchResult(url, count);
             })
             .mapAsync(6, sch -> Patterns.ask(actorSystem, SearchResult, Duration.ofMillis(3000))
                     .thenCompose(res -> {
                         TestResult tmpTestResult =TestResult res;
                         Sink<SearchResult, CompletionStage<Long>> testSink =Flow.<SearchResult>create()
                                 .mapConcat((r) -> Collections.nCopies(r.getCount(), r.getURL()))
                                 .mapAsync(6, url -> {
                                     long start = System.nanoTime();
                                     return httpClient
                                             .
                                 }


             }
    }





    }

