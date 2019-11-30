import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

import static akka.actor.TypedActor.self;

public class actorSystem {

        private HashMap  <String, Integer> store = new HashMap<>();
        //id res
        @Override
        public AbstractActor.Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(SearchResult.class, m -> {
                        String url = m.getURL();
                        int count = m.getCount();
                            if(store.containsKey(url) && store.get(url).co)
                    })
                    .match(TestResult.class, m -> {
                        store.put(m.getURL(), m.getTime());
                    })
            .build();

    }


}
