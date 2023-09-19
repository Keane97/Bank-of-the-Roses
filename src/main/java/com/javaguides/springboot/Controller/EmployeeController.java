package com.javaguides.springboot.Controller;

import com.javaguides.springboot.Model.Employee;
import com.javaguides.springboot.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController     //or @Controller (@Restcontoller combines @Controller and @ResponseBody, eliminating the need to annotate each method)
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Build create employee REST API Endpoint
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //Build GET all employees REST API Endpoint
    @GetMapping
    public List<Employee> getEmployees(){
        return  employeeService.getAllEmployeees();
    }

    // Build Get Singular employee Rest API Endpoint
    //http://localhost:8080/api/employees/1         -> Endpoint of a valid URL for retrieving the record with the id of "1"
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeByID(employeeId), HttpStatus.OK);
    }

    //http://localhost:8080/api/employees/1         -> Endpoint of a valid URL for retrieving the record with the id of "1"
    @PutMapping(value = "{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    //Build DELETE singular employee REST API Endpoint
    //http://localhost:8080/api/employees/1         -> Endpoint of a valid URL for retrieving the record with the id of "1"
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }

}
