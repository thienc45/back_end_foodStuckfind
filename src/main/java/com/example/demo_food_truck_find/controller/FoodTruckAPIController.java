package com.example.demo_food_truck_find.controller;

import com.example.demo_food_truck_find.service.FoodTruckAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*", "http://localhost:3000", "http://13.229.132.219:3000", "http://13.212.152.8:3000"})
public class FoodTruckAPIController {
    private final FoodTruckAPIService foodTruckAPIService;


    @Autowired
    public FoodTruckAPIController(FoodTruckAPIService foodTruckAPIService) {
        this.foodTruckAPIService = foodTruckAPIService;
    }


    @GetMapping("/food-trucks")
    public String getFoodTruckData() {
        return foodTruckAPIService.getFoodTruckData();
    }


    @GetMapping("/food-trucks/search")
    public String searchFoodTrucksByLocationDescription(@RequestParam(required = false) String locationDescription) {
        if (locationDescription == null || locationDescription.isEmpty()) {
            return foodTruckAPIService.getFoodTruckData();
        } else {
            return foodTruckAPIService.getFoodTruckDataByLocationDescription(locationDescription);
        }
    }


}
