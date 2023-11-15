package com.school.repositories;

import org.springframework.data.repository.CrudRepository;

import com.school.models.Director;

public interface DirectorRepository extends CrudRepository<Director, Long>{
	
}