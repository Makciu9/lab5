public class actorSystem {

        private HashMap  <Integer, ArrayList<Test>> store = new HashMap<>();
        //id res
        @Override
        public Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(StoreMassage.class, m -> {
                        if (!store.containsKey(m.getPackageID()))
                            store.put(m.getPackageID(), m.getTests());
                        else {
                            ArrayList<Test> res = store.get(m.getPackageID());
                            res.addAll(m.getTests());
                            store.replace(m.getPackageID(), res);
                        }
                        System.out.println("receive message! " + m);
                    })
                    .match(GetMessage.class,  req -> { sender().tell(
                            new StoreMassage(req.getPackageID(), store.get(req.getPackageID())), self());
                    }).build();
    }


}
