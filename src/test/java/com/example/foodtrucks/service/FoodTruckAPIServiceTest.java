package com.example.foodtrucks.service;


import com.example.foodtrucks.config.AppConfig;


import com.example.foodtrucks.contants.ConstantsApiUrl;
import com.example.foodtrucks.service.impl.FoodTruckAPIServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//test của em đang fail
@SpringBootTest(classes = {FoodTruckAPIServiceImpl.class, AppConfig.class})
public class FoodTruckAPIServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    private FoodTruckAPIServiceImpl foodTruckAPIService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFoodTruckData() {

        // Dữ liệu giả định trả về từ API
        String fakeData = "[{\"objectid\":\"735318\",\"applicant\":\"Ziaurehman Amini\",\"facilitytype\":\"Push Cart\",\"locationdescription\":\"MARKET ST: DRUMM ST intersection\",\"address\":\"5 THE EMBARCADERO\"},{\"objectid\":\"848184\",\"applicant\":\"Reecees Soulicious\",\"facilitytype\":\"Truck\",\"locationdescription\":\"BAY SHORE BLVD: BAY SHORE BLVD to OAKDALE AVE (185 - 299) -- EAST --\",\"address\":\"201 BAY SHORE BLVD\"}]";

        // Mocking việc gọi API để trả về dữ liệu giả định
        when(restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class)).thenReturn(fakeData);

        // Gọi hàm cần kiểm thử
        String foodTruckData = foodTruckAPIService.getFoodTruckData();

        // Kiểm tra kết quả
        assertEquals(fakeData, foodTruckData);

        // Kiểm tra xem phương thức restTemplate.getForObject đã được gọi chưa
        verify(restTemplate, times(1)).getForObject(ConstantsApiUrl.API_URL, String.class);
    }
}
