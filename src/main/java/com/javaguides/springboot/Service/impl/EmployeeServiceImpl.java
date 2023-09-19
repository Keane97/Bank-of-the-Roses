package com.javaguides.springboot.Service.impl;

import com.javaguides.springboot.Exception.ResourceNotFoundException;
import com.javaguides.springboot.Model.Employee;
import com.javaguides.springboot.Service.EmployeeService;
import com.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    } //IMPL stands for implementation

    @Override
    public List<Employee> getAllEmployeees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//
//        if (employee.isPresent()) {
//            return employee.get();
//        } else  {
//            throw new ResourceNotFoundException("Employee", "id", id);
//        }

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id)); //lambda expression (The above "if/else" does the same thing)
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
    //find employee by id first
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setAboutMe(employee.getAboutMe());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setImage(employee.getImage());
        //save existing employee to DB

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check if the employee exists
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
         employeeRepository.deleteById(id);
    }


}
