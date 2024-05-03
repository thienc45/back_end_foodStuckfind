package com.example.foodtrucks.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@SecurityScheme(name = "bearerAuth", scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER)
@CacheConfig(cacheNames = "test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @Operation(summary = "This method is used to get the clients.")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }


    @Operation(summary = "This method is used to get the clients.")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @Operation(summary = "This method is used to get the clients.")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Board.";
    }
}
