package com.sp.redis.count;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = {
        "com.sp.redis.model",
        "com.sp.redis.count"
})
@EnableRedisRepositories(basePackages = "com.sp.redis.model")
@EnableWebMvc
@SpringBootApplication
public class EventCountServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventCountServerApplication.class);
    }

}
