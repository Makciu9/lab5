import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class ServerResult {
    ActorRef actorSystem;
    static Flow<HttpRequest, HttpResponse, NotUsed> ServerResult(){
        system.actorOf(Props.create(actorSystem.class)

    }
}
