package com.example.foodtrucks.service.impl;

import com.example.foodtrucks.contants.ConstantsApiUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodTruckAPIServiceImpl {

    private final RestTemplate restTemplate;

    @Autowired
    public FoodTruckAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("foodtrucks")
    public String getFoodTruckData() {
        doLongRunningTask();
        System.out.println(restTemplate);
        return restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class);
    }

    @Cacheable("foodtrucks")
    public String getFoodTruckDataByLocationDescription(String locationDescription) {
        doLongRunningTask();
        String apiUrlWithFilter = ConstantsApiUrl.API_URL + "?$where=locationDescription like '%" + locationDescription + "%'";
        return restTemplate.getForObject(apiUrlWithFilter, String.class);
    }


    private void doLongRunningTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
