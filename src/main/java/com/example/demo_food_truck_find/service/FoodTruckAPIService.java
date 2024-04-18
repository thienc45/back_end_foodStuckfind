package com.example.demo_food_truck_find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class FoodTruckAPIService {
    private final String API_URL = "https://data.sfgov.org/resource/rqzj-sfat.json";

    private final RestTemplate restTemplate;

    @Autowired
    public FoodTruckAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFoodTruckData() {
        System.out.println(restTemplate);
        return restTemplate.getForObject(API_URL, String.class);
    }

    public String getFoodTruckDataByLocationDescription(String locationDescription) {
        String apiUrlWithFilter = API_URL + "?$where=locationDescription like '%" + locationDescription + "%'";
        return restTemplate.getForObject(apiUrlWithFilter, String.class);
    }
}
