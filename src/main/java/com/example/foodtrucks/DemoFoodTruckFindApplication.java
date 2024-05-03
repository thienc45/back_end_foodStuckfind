package com.example.foodtrucks;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication
//@SecurityScheme(name = "basicAuth", scheme = "basic",
//        type = SecuritySchemeType.HTTP,
//        in = SecuritySchemeIn.HEADER) đổi authen thành breare thì nó thành một kiểu phân quyêền khác
@OpenAPIDefinition(
        info = @Info(title = "Swagger API Test",
                version = "1.0",
                description = "StuckFood Information"),
        externalDocs = @ExternalDocumentation(description = "Basic for OAS to lean OAS with spring boot and jwt",
                url = "https://www.javainuse.com/spring/boot_swagger3"))
//@EnableCaching
@SpringBootApplication
public class DemoFoodTruckFindApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFoodTruckFindApplication.class, args);
    }
}
