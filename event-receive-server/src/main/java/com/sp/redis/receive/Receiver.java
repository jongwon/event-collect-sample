package com.sp.redis.receive;

import com.sp.redis.model.Event;
import com.sp.redis.model.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Slf4j
public class Receiver {


    @Autowired
    private EventRepository repository;

    public Receiver() {
        System.out.println("receiver : "+this.toString());
    }

    public void receiveMessage(String eventId) {
//        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional<Event> result = repository.findById(eventId);
            if(result.isPresent()) {
                log.info("Received <" + result.get() + ">");
            }else{
                log.error("No Event : "+eventId);
            }
//        }).start();

    }

}