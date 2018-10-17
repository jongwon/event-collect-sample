package com.sp.redis.test;


import com.sp.redis.model.Event;
import com.sp.redis.model.EventRepository;
import com.sp.redis.regist.EventRegistServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ReactiveStringCommands;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@DataRedisTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes= EventRegistServerApplication.class)
public class SaveEventTest {

    @Autowired
    private EventRepository eventRepository;

//    @Test
    public void findEvent(){

        System.out.println("find event...");
        eventRepository.findAll().forEach(event -> {

            System.out.println("123");
            System.out.println(event);
        });
        System.out.println("adsfadsfasdf  ");
    }


    @Test
    public void insertEvent() {

        System.out.println("start....");

        Event event = new Event();
        event.setEventId("4abc");
        event.setEventName("Test-4abc");
        event.setClickCount(0);
        event.setViewCount(0);
//        event.setHistoryList();

        eventRepository.save(event);

        event = new Event();
        event.setEventId("5abc");
        event.setEventName("Test-5abc");
        event.setClickCount(0);
        event.setViewCount(0);
//        event.setHistoryList();

        eventRepository.save(event);

        event = new Event();
        event.setEventId("6abc");
        event.setEventName("Test-6abc");
        event.setClickCount(0);
        event.setViewCount(0);
//        event.setHistoryList();

        eventRepository.save(event);


        event = eventRepository.findById("4abc").get();

        System.out.println("event saved : "+event);

        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);

        System.out.println(events);

        System.out.println("find event...");
        eventRepository.findAll().forEach(e -> {

            System.out.println("123");
            System.out.println(e);
        });
        System.out.println("adsfadsfasdf  ");
    }


}
