package com.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.models.Alumno;
import com.school.repositories.AlumnoRepository;
import com.project.utility.Converter;

@Service

public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;
	Converter converter = new Converter();


	public Alumno saveAlumnoDB(Alumno x) {
		return alumnoRepository.save(x);
	}
	
	public ArrayList<Alumno> getAllAlumnosDB(){
		return (ArrayList<Alumno>) alumnoRepository.findAll();
	}
	
	public void deleteAllAlumnosDB() {
		alumnoRepository.deleteAll();
	}
	
	public void deleteAlumnoDB(Long x) {
		alumnoRepository.deleteById(x);
	}
	
	public Alumno getAlumnoByDocument(int x) {
		Alumno alumno = new Alumno();
		ArrayList<Alumno> lista = this.getAllAlumnosDB();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getAlumno_document() == x) {
				alumno = lista.get(i);
			}else {
				alumno = null;
			}
		}
		return alumno;
	}
}
