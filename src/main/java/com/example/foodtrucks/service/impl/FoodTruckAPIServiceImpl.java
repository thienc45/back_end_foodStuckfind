package com.example.foodtrucks.service.impl;

import com.example.foodtrucks.contants.ConstantRedisKey;
import com.example.foodtrucks.contants.ConstantsApiUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class FoodTruckAPIServiceImpl {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public String getFoodTruckData() {
        String cacheData = (String) redisTemplate.opsForValue().get(ConstantRedisKey.KEY_FOODSTUCK_ALL);

        if (cacheData != null) {
            System.out.println("Retrieved data from cache");
            return cacheData;
        } else {
            String redisData = restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class);
            redisTemplate.opsForValue().set(ConstantRedisKey.KEY_FOODSTUCK_ALL, redisData, Duration.ofMinutes(1));
            System.out.println("Retrieved data from Redis and cached");
           return redisData;
        }
    }

    public String getFoodTruckDataByLocationDescription(String locationDescription) {
        String cachedData = (String) redisTemplate.opsForValue().get(locationDescription);
        if (cachedData != null) {
            System.out.println("Retrieved data from Redis cache");
            return cachedData;
        } else {
            String apiUrlWithFilter = ConstantsApiUrl.API_URL + "?$where=locationDescription like '%" + locationDescription + "%'";
            String data = restTemplate.getForObject(apiUrlWithFilter, String.class);
            redisTemplate.opsForValue().set(ConstantRedisKey.KEY_FOODSTUCK_FIND + locationDescription, data,Duration.ofMinutes(1));
            System.out.println("Data cached in Redis");
            return data;
        }
    }

}
