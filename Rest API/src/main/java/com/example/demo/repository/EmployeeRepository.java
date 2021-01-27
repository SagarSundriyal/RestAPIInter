package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
@Component
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

	List<Employee> findAll();

	Optional<Employee> findById(Long employeeIdentity);

}
