package com.sp.redis.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event implements Serializable {

    @Id
    private String eventId;

    private String eventName;

    private int viewCount;

    private int clickCount;

    private List<EventHistory> historyList;


    public int addViewCount(){
        this.viewCount += 1;
        this.clickCount += 1;
        return this.viewCount;
    }

}
