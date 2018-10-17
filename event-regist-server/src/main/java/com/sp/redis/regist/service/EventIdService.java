package com.sp.redis.regist.service;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EventIdService {
	
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valusOps;
	
	public Long nextId() {
		Long count = 0L;
		try {
			valusOps.increment("event-count", 1);
			count = Long.valueOf(valusOps.get("event-count"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
