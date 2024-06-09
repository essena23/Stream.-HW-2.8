package com.example.Stream30.Controller;

import com.example.Stream30.Model.Employee;
import com.example.Stream30.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(int departmentId){
        return employeeService.getMinSalary(departmentId);

    }
    @GetMapping (path = "/max-salary")

    public Employee getMaxSalary(int departmentId){
        return employeeService.getMaxSalary(departmentId);

    }
    @GetMapping (path = "/all")

    public List<Employee> getAllEmployeesByDepartment(int departmentId){
        return employeeService.getAllEmployeesByDepartment(departmentId);

    }
    @GetMapping (path = "/all-grouped")

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment(){
        return employeeService.getAllEmployeesGroupedByDepartment();

    }
}

