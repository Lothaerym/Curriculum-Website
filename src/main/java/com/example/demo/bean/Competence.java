package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Competence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String Programmation;
	String Data;
	String Frameworks;
	String Autres;
	
	public Competence() {
		
	}
	
	public Competence(int id, String programmation, String data, String frameworks, String autres) {
		super();
		this.id = id;
		Programmation = programmation;
		Data = data;
		Frameworks = frameworks;
		Autres = autres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgrammation() {
		return Programmation;
	}

	public void setProgrammation(String programmation) {
		Programmation = programmation;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getFrameworks() {
		return Frameworks;
	}

	public void setFrameworks(String frameworks) {
		Frameworks = frameworks;
	}

	public String getAutres() {
		return Autres;
	}

	public void setAutres(String autres) {
		Autres = autres;
	}
	
	
}
