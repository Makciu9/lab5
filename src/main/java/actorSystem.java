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
                            store.put(m.getURL(), m.getCount());
                    })
                    .match(TestResult.class, m -> {
                        boolean eval=false;
                        int resultTime=-1;
                        if (store.containsKey(m.getURL())){
                            eval=true;
                            resultTime=store.get(m.getTime());
                        }
                        sender().tell(1, self());
                    });

    }


}
