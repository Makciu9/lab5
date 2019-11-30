import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;

public class ServerResult {
    ActorRef actorSystem;
    static void ServerResult(Http http, ActorSystem system, ActorMaterializer materializer){
        system.actorOf(Props.create(actorSystem.class);

    }
}
