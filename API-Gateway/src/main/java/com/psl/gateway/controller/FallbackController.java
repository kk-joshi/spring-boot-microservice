package com.psl.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/userServiceFallback")
    public String fallbackForUserService() {
        return "User Service is taking more time than expected. Please try again after sometime";
    }

    @GetMapping("/departmentServiceFallback")
    public String fallbackForDepartmentService() {
        return "Department Service is taking more time than expected. Please try again after sometime";
    }

}
