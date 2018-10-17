package com.sp.redis.count.controller;


import com.sp.redis.model.Event;
import com.sp.redis.model.EventRepository;
import com.sp.redis.model.RedisEventViewPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RequestMapping(value="/event")
@RestController
public class EventRetrieveController {


    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RedisEventViewPublisher eventViewPublisher;


    @GetMapping(value="/view/{eventId}")
    public Event getEvent(
            @PathVariable(name="eventId") String eventId,
            HttpServletRequest request
    ){

        Optional<Event> ressult = eventRepository.findById(eventId);
        if(ressult.isPresent()){
            Event event = ressult.get();
            int views = event.addViewCount();

            // save EventHistory ...

            eventRepository.save(event);

            eventViewPublisher.publish(eventId);
            log.info("Event {} : {} 전송함", eventId, views);

            return event;
        }
        return new Event();
    }

}
