package com.javaguides.springboot.Service;

import com.javaguides.springboot.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployeees();
    Employee getEmployeeByID(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
