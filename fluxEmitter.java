package com.example.rsockettest;

import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Sinks;

public class ScheduledEmitter {

    public static Sinks.Many<String> singleSinkObject;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        Long curTime  = System.currentTimeMillis() / 1000;
        System.out.println("Fixed delay task - " + curTime);
        singleSinkObject.emitNext("Data from backend" + curTime.toString(), (e, ex) -> true);
    }
}
