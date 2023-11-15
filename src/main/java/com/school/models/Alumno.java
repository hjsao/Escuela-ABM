package com.school.models;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

@Component
@Entity(name="alumno")
@Table(name="alumno")
public class Alumno {
	@Id
	@Column(name="Document")
	Long alumno_document;
	
	@Column(name="Name",length=20)
	String alumno_name;

	@Column(name="Surname",length=20)
	String alumno_surname;
	
	@Column(name="Anio")
	int alumno_anio;
	
	@Column(name="Division")
	int alumno_division;
	
	@Column(name="Release_datetime", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime alumno_release_datetime;
	
	public Alumno() {
		super();
	}

	public Alumno(Long alumno_document, String alumno_name, String alumno_surname, int alumno_anio, int alumno_division,
			LocalDateTime alumno_release_datetime) {
		super();
		this.alumno_document = alumno_document;
		this.alumno_name = alumno_name;
		this.alumno_surname = alumno_surname;
		this.alumno_anio = alumno_anio;
		this.alumno_division = alumno_division;
		this.alumno_release_datetime = alumno_release_datetime;
	}

	public Long getAlumno_document() {
		return alumno_document;
	}

	public void setAlumno_document(Long alumno_document) {
		this.alumno_document = alumno_document;
	}

	public String getAlumno_name() {
		return alumno_name;
	}

	public void setAlumno_name(String alumno_name) {
		this.alumno_name = alumno_name;
	}

	public String getAlumno_surname() {
		return alumno_surname;
	}

	public void setAlumno_surname(String alumno_surname) {
		this.alumno_surname = alumno_surname;
	}

	public int getAlumno_anio() {
		return alumno_anio;
	}

	public void setAlumno_anio(int alumno_anio) {
		this.alumno_anio = alumno_anio;
	}

	public int getAlumno_division() {
		return alumno_division;
	}

	public void setAlumno_division(int alumno_division) {
		this.alumno_division = alumno_division;
	}

	public LocalDateTime getAlumno_release_datetime() {
		return alumno_release_datetime;
	}

	public void setAlumno_release_datetime(LocalDateTime alumno_release_datetime) {
		this.alumno_release_datetime = alumno_release_datetime;
	}

	
}

	