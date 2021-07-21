package com.psl.department.controller;

import com.psl.department.objects.Department;
import com.psl.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public String saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment in controller");
        department = departmentService.saveDepartment(department);
        return "Department has been saved with ID " + department.getId();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        log.info("Inside getMethod");
        Department d = departmentService.findDepartmentById(departmentId);
        log.info("Department object is {}", d);
        return d;
    }


}
