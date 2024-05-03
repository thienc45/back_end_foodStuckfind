package com.example.foodtrucks.repository.redis.impl;

import com.example.foodtrucks.repository.redis.BaseRedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//@Service
public class BookRedisServiceImpl implements BaseRedisService {
    private final HashOperations<String, String, Object> hashOperations;
    private final RedisTemplate<String, Object> redisTemplate;

    public BookRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }



    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setTimeToLive(String key, long timeoutInDays) {
        redisTemplate.expire(key, timeoutInDays, TimeUnit.DAYS);
    }

    @Override
    public void hashSet(String key, String field, Object value) {
        hashOperations.put(key, field, value);
    }

    @Override
    public boolean hashExists(String key, String field) {
        return hashOperations.hasKey(key, field);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Map<String, Object> getField(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public Object hashGet(String key, String field) {
        return hashOperations.get(key, field);
    }

    @Override
    public List<Object> hashGetByFieldPrefix(String key, String filedPrefix) {
        List<Object> list = new ArrayList<>();

        Map<String, Object> hashMap = hashOperations.entries(key);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry.getKey().startsWith(filedPrefix)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    @Override
    public Set<String> getFieldPrefixes(String key) {
        return hashOperations.entries(key).keySet();
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(String key, String field) {
        hashOperations.delete(key, field);
    }

    @Override
    public void delete(String key, List<String> fields) {
        for (String field : fields) {
            hashOperations.delete(key, field);
        }
    }

}
