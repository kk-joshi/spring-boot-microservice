package com.psl.department.service;

import com.psl.department.objects.Department;
import org.springframework.stereotype.Service;


public interface DepartmentService {
    Department saveDepartment(Department department);
    Department findDepartmentById(Long id);
}
