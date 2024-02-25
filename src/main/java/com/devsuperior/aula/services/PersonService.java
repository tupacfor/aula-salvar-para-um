package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

import dtos.PersonDepartmentDTO;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person entity = new Person(dto);
		Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());
		entity.setDepartment(department);
		entity = repository.save(entity);
		return new PersonDepartmentDTO(entity);
		
	}
	
}
