package com.example.foodtrucks.service.impl;

import com.example.foodtrucks.contants.ConstantsApiUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@CacheConfig(cacheNames = "foodtrucks")
public class FoodTruckAPIServiceImpl {

    private final RestTemplate restTemplate;

    @Autowired
    public FoodTruckAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable()
    public String getFoodTruckData() {
        System.out.println(restTemplate);
        return restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class);
    }

    @Cacheable()
    public String getFoodTruckDataByLocationDescription(String locationDescription) {
        String apiUrlWithFilter = ConstantsApiUrl.API_URL + "?$where=locationDescription like '%" + locationDescription + "%'";
        return restTemplate.getForObject(apiUrlWithFilter, String.class);
    }

}
