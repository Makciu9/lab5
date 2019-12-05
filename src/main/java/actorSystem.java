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
                    .match(SearchResult.class, m -> {

                        String url = m.getURL();
                        int count = m.getCount();
                        System.out.print(url);
                           sender().tell(new SearchResult(m.getURL(), count), self());

                    })
                    .match(TestResult.class, m -> {
                        store.put(m.getURL(), m.getTime());
                    })
            .build();

    }

    


}
