package com.sp.redis.regist.controller;


import com.sp.redis.model.Event;
import com.sp.redis.model.EventRepository;
import com.sp.redis.regist.service.EventIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping(value="/event")
public class EventRegistController {

    @Autowired
    private EventIdService eventIdService;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(value="/new")
    public Event makeEvent(){

        Long eventId = eventIdService.nextId();
        Event event = new Event();
        event.setEventId(""+eventId);
        event.setEventName(format("event-%d", eventId));
        event.setViewCount(0);
        event.setClickCount(0);

        eventRepository.save(event);

        return event;
    }




}
