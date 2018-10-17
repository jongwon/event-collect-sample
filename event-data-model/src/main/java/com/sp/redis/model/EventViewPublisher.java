package com.sp.redis.model;

public interface EventViewPublisher {
    void publish(String message);
}