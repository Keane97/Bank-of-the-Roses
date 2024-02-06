package com.BankOfTheRoses.repository;

import com.BankOfTheRoses.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA internally provides @Repository Annotation, so we don't need to add @Repository annotation to EmployeeRepository interface
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
