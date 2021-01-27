package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/request")
public class EmployeeDetails {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/details")
	public List<Employee> getAllInformations()
	{
		return employeeRepository.findAll();
	}
	
	
	@GetMapping("/details/{id}")
   public ResponseEntity<Employee> getInformationById(@PathVariable(name = "id") Long employeeIdentity) throws ResourceNotFoundException
   {
		Employee emp = employeeRepository.findById(employeeIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Exception NOT FOUND BY ID :" +employeeIdentity));
		
		return ResponseEntity.ok().body(emp);
   }
	
	
	@PostMapping("/employees")
	public Employee create(@Valid @RequestBody Employee employeeee)
	{
		return employeeRepository.save(employeeee);
	}
	
	@PostMapping("/details/{Id}")
	public ResponseEntity<Employee> updateDetails(@PathVariable(name = "Id") Long employeeIdentity , @Valid @RequestBody Employee employeeInformation)throws ResourceNotFoundException
	{
		Employee emp = employeeRepository.findById(employeeIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Exception NOT FOUND BY ID :" +employeeIdentity));
		
		emp.setName(employeeInformation.getName());
		emp.setMobileNo(employeeInformation.getMobileNo());
		emp.setEmail_id(employeeInformation.getEmail_id());
		emp.setDateOfBirth(employeeInformation.getDateOfBirth());
		
		final Employee updatedddDetails = employeeRepository.save(emp);
		return ResponseEntity.ok(updatedddDetails);
	}
	
	@DeleteMapping("/details/{deleteById}")
	public Map<String , Boolean> deleteDetails(@PathVariable(name = "deleteById")Long employeeIdentity)throws ResourceNotFoundException
	{
		Employee emp = employeeRepository.findById(employeeIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Exception NOT FOUND BY ID :" +employeeIdentity));
		
		employeeRepository.delete(emp);
		
		Map<String , Boolean> mapping = new HashMap<>();
		mapping.put("deleted", Boolean.TRUE);
		return mapping;
	}
	
}
