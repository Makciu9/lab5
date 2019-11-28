import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

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
                        Long resultTime=-1l;
                        if (store.containsKey(m.getURL())){
                            
                        }


                        store.put(m.getURL(), m.getCount());
                    })

    }


}
