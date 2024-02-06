package com.BankOfTheRoses.Service.impl;

import com.BankOfTheRoses.Exception.ResourceNotFoundException;
import com.BankOfTheRoses.Model.Employee;
import com.BankOfTheRoses.Service.EmployeeService;
import com.BankOfTheRoses.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


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
