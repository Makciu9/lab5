import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

import static akka.actor.TypedActor.self;

public class actorSystem extends AbstractActor {

        private HashMap  <String, Long> store = new HashMap<>();
        //id res
        @Override
        public AbstractActor.Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(TestResult.class, m -> {

                        String url = m.getURL();
                        Long count = (long) m.getURL();
                        System.out.print(url);
                        System.out.print(count);
                        if (store.containsKey(m.getURL())) {
                            sender().tell(new SearchResult(m.getURL(), count), self());
                        }
                        else sender().tell(new SearchResult(m.getURL(), -1l), self())

                    })
                    .match(TestResult.class, m -> {
                        System.out.print(m.getURL());
                        store.put(m.getURL(), m.getTime());
                    })
            .build();

    }

    


}
