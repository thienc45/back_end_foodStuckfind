package com.example.foodtrucks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger API Test", version = "2.0", description = "StuckFood Information"))
@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class DemoFoodTruckFindApplication {

    public static void main(String[] args) {
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> f4458f5 (.)
>>>>>>> c4726691d69de1089efb192179c21db6cee1675a
        SpringApplication.run(DemoFoodTruckFindApplication.class, args);
    }

}
