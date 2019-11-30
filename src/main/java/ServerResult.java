import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.Map;

public class ServerResult {
    static ActorRef actorSystem;

 static Flow<HttpRequest, HttpResponse, NotUsed> ServerFlow (Http http, ActorSystem system, ActorMaterializer materializer ){
     actorSystem = system.actorOf(Props.create(actorSystem.class));
     return Flow
             .of(HttpRequest.class)
             .map((req)-> {
                 Map<String, String> paramsMap = req.getUri().query().toMap();

             }
    }





    }

