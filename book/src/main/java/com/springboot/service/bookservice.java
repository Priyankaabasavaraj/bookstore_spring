package com.springboot.service;

import com.springboot.model.book;

import java.util.List;

public interface bookservice {

		List<book> getAllEmployees();
		void saveEmployee(book employee);
		book getEmployeeById(long Id);
		void deleteEmployeeById(long id);
	}
