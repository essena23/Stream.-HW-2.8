package com.example.Stream30.Service;

import com.example.Stream30.Model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee getMinSalary(int department);

    Employee getMaxSalary(int department);

    List<Employee> getAllEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();

}
