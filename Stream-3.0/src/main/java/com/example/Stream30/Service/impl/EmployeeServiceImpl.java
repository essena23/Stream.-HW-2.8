package com.example.Stream30.Service.impl;

import com.example.Stream30.Model.Employee;
import com.example.Stream30.Service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    @PostConstruct
    public void init() {
        employees.put("Трындеева", new Employee("Трындеева Любовь Аркадьевна", 5, 65_000));
        employees.put("Окунь", new Employee("Окунь Махрипа Люсьевна", 5, 75_000));
        employees.put("Пыж", new Employee("Пыж Андрей Никитьич", 1, 85_000));
        employees.put("Скороговоркина", new Employee("Скороговоркина Ольга Андреевна", 2, 70_000));
        employees.put("Огнище", new Employee("Огнище Марина Петровна", 4, 74_000));
        employees.put("Писуль", new Employee("Писуль Карл Карлович", 3, 69_000));
        employees.put("Аркашин", new Employee("Аркашин Яков Иванович", 1, 71_000));
        employees.put("Якубович", new Employee("Якубович Дмитрий Борисович", 4, 66_000));
        employees.put("Лялякишева", new Employee("Лялякишева Светланка Александровна", 2, 83_000));
        employees.put("Мякишева", new Employee("Мякишева Кристина Алексеевна", 3, 78_000));
    }

    @Override
    public Employee getMinSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getMaxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
