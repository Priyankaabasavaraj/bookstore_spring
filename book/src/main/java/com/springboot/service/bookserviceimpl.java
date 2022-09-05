package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.book;
import com.springboot.repository.bookrepository;

@Service
public class bookserviceimpl implements bookservice{
	

		@Autowired
		private bookrepository employeeRepository;

		@Override
		public List<book> getAllEmployees() {
			return  employeeRepository.findAll() ;
		}

		@Override
		public void saveEmployee(book employee) {
			this.employeeRepository.save(employee);
		}

		@Override
		public book getEmployeeById(long id) {
			Optional<book> optional = employeeRepository.findById(id);
			book employee =null;
			if(optional.isPresent())
			{
				employee=optional.get();
			}
			else
			{
				throw new RuntimeException("Employee not found for id : : "+id);
			}
			return employee;
		}

		@Override
		public void deleteEmployeeById(long id) {
			this.employeeRepository.deleteById(id);
			
		}
		
		
	
}
