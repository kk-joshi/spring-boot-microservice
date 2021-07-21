package com.psl.user.controller;

import com.psl.user.objects.User;
import com.psl.user.objects.value.Department;
import com.psl.user.objects.value.UserWithDepartment;
import com.psl.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(com.psl.user.service.UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/")
    public String saveUser(@RequestBody User user) {
        log.info("Inside saveUser in controller");
        user = userService.saveUser(user);
        return "{\"User has been saved with ID " + user.getId() +"\"}";
    }

    @GetMapping("/{id}")
    public UserWithDepartment getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getMethod");
        User u = userService.findUserById(userId);
        Department d = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + u.getDepartmentId(), Department.class);

        return new UserWithDepartment(u, d);
    }


}
