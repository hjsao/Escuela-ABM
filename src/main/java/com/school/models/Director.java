package com.school.models;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

@Component
@Entity(name="director")
@Table(name="director")
public class Director {
	@Id
	@Column(name="Document")
	Long Director_document;
	
	@Column(name="Name",length=20)
	String Director_name;

	@Column(name="Surname",length=20)
	String Director_surname;
	
	@Column(name="email", length=100)
	String Director_email;
	
	@Column(name="Password", length=200)
	String Director_password;
	
	@Column(name="Release_datetime", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime user_release_datetime;
	
	public Director() {
		super();
	}

	public Director(String Director_name, String Director_surname, String Director_email,
			String Director_password, Long Director_document, LocalDateTime user_release_datetime) {
		super();
		this.Director_name = Director_name;
		this.Director_surname = Director_surname;
		this.Director_email = Director_email;
		this.Director_password = Director_password;
		this.Director_document = Director_document;
		this.user_release_datetime = user_release_datetime;
	}
	public String getDirector_name() {
		return Director_name;
	}

	public void setDirector_name(String Director_name) {
		this.Director_name = Director_name;
	}

	public String getDirector_surname() {
		return Director_surname;
	}

	public void setDirector_surname(String Director_surname) {
		this.Director_surname = Director_surname;
	}

	public String getDirector_email() {
		return Director_email;
	}

	public void setDirector_email(String Director_email) {
		this.Director_email = Director_email;
	}

	public String getDirector_password() {
		return Director_password;
	}

	public void setDirector_password(String Director_password) {
		this.Director_password = Director_password;
	}

	public Long getDirector_document() {
		return Director_document;
	}

	public void setDirector_document(Long Director_document) {
		this.Director_document = Director_document;
	}

	public LocalDateTime getDirector_release_datetime() {
		return user_release_datetime;
	}

	public void setDirector_release_datetime(LocalDateTime user_release_datetime) {
		this.user_release_datetime = user_release_datetime;
	}
}

	