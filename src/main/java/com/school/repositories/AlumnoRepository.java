package com.school.repositories;

import org.springframework.data.repository.CrudRepository;

import com.school.models.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
	
}
