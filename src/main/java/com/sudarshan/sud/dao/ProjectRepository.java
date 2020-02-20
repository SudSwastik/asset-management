package com.sudarshan.sud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sudarshan.sud.entities.Employee;

@Service
public interface ProjectRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
}
