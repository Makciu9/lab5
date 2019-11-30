import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class ServerResult {
    ActorRef actorSystem;
    ServerResult(ActorSystem system) {system.actorOf(Props.create(actorSystem.class));}
    Flow<HttpRequest, HttpResponse, NotUsed> getFLOW(ActorMaterializer materializer,){

    }
}
