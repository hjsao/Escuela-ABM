package com.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.models.Director;
import com.school.repositories.DirectorRepository;
import com.project.utility.Converter;

@Service

public class DirectorService {
	@Autowired
	DirectorRepository directorRepository;
	Converter converter = new Converter();


	public void saveDirectorDB(Director x) {
		directorRepository.save(x);
	}
	
	public ArrayList<Director> getAllDirectorsDB(){
		return (ArrayList<Director>) directorRepository.findAll();
	}
	
	public void deleteAllDirectorsDB() {
		directorRepository.deleteAll();
	}
	
	public void deleteDirectorDB(Long x) {
		directorRepository.deleteById(x);
	}
	
	public Director getDirectorByDocument(int x) {
		Director Director = new Director();
		ArrayList<Director> lista = this.getAllDirectorsDB();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDirector_document() == x) {
				Director = lista.get(i);
			}else {
				Director = null;
			}
		}
		return Director;
	}
	public Director getDirectorByEmailAndPassword(String x, String z) {
		Director Director = new Director();
		ArrayList<Director> lista = this.getAllDirectorsDB();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDirector_password().equalsIgnoreCase(z) && lista.get(i).getDirector_email().equalsIgnoreCase(x)) {
				Director = lista.get(i);
			} else {
				Director = null;
			}
		}
		return Director;
	}
}
