package com.example.foodtrucks.service;

import com.example.foodtrucks.contants.ConstantsApiUrl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//test của em đang fail
@WebMvcTest(FoodTruckAPIService.class)
public class FoodTruckAPIServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    private FoodTruckAPIService foodTruckAPIService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testGetFoodTruckData() {
        // Dữ liệu giả mạo để trả về từ API
        String mockResponse = "Your mock response here";

        // Thiết lập kết quả trả về mong đợi từ RestTemplate
        when(restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class)).thenReturn(mockResponse);

        // Gọi phương thức của dịch vụ và kiểm tra kết quả
        String actualResponse = foodTruckAPIService.getFoodTruckData();
        assertEquals(mockResponse, actualResponse);
    }

    @Test
    public void testGetFoodTruckDataByLocationDescription() {
        // Dữ liệu giả mạo để trả về từ API
        String locationDescription = "ST01";
        String mockResponse = restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class);

        // Tạo URL mong đợi dựa trên mô tả vị trí
        String expectedApiUrl = ConstantsApiUrl.API_URL + "?$where=locationDescription like '%" + locationDescription + "%'";

        // Thiết lập kết quả trả về mong đợi từ RestTemplate
        when(restTemplate.getForObject(expectedApiUrl, String.class)).thenReturn(mockResponse);

        // Gọi phương thức của dịch vụ và kiểm tra kết quả
        String actualResponse = foodTruckAPIService.getFoodTruckDataByLocationDescription(locationDescription);
        assertEquals(mockResponse, actualResponse);
    }
}
