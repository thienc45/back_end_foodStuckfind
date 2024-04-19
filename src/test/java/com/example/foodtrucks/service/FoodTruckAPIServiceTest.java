package com.example.foodtrucks.service;

<<<<<<< HEAD
import com.example.foodtrucks.config.AppConfig;
=======
>>>>>>> f4458f5 (.)
import com.example.foodtrucks.contants.ConstantsApiUrl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
<<<<<<< HEAD
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
=======
>>>>>>> f4458f5 (.)
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< HEAD
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//test của em đang fail
@SpringBootTest(classes = {FoodTruckAPIService.class, AppConfig.class})
=======
import static org.mockito.Mockito.when;
//test của em đang fail
@SpringBootTest
>>>>>>> f4458f5 (.)
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
<<<<<<< HEAD
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


=======
        // Dữ liệu giả mạo để trả về từ API
        String mockResponse = restTemplate.getForObject(ConstantsApiUrl.API_URL, String.class);

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
>>>>>>> f4458f5 (.)
}
