@MessageMapping("newonechannel_{id}")
    public Flux<ArrayList<String>> channelNew_withId(Flux<String> input, @DestinationVariable("id") String id) {
        logger.info("Inside server : Just entered");
        input
              .doOnNext(element -> logger.info("Received this element on server side : {}", element))
              .switchMap(element -> Flux.just("I am server!"))
              .log();
        logger.info("Inside server : Now returning the flux");
        Predicate<ArrayList<String>> predicate1 = new Predicate<ArrayList<String>>() {
            @Override
            public boolean test(ArrayList<String> s) {
                System.out.println(s);
                if(s.contains(id)){
                    return true;
                }
                else{
                    return false;
                }

            }
        };
        return singleSinkObject.asFlux().filter(predicate1);

    }
