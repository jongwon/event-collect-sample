package com.sp.redis.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisEventViewPublisher implements EventViewPublisher {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String channel="event-view";

    public RedisEventViewPublisher() {
    }

    public RedisEventViewPublisher(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(String eventId) {
        redisTemplate.convertAndSend(channel, eventId);
    }

}
