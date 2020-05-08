package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Administrator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="PWD")
    private String pwd;
	@Column(name="NAME")
    private String name;
    
    public Administrator() {}
    
    public Administrator(int id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
    
    public void setId(int id) {
	this.id = id;
    }
    public int getId() {
	return id;
    }
    
    public void setPwd(String pwd) {
	this.pwd = pwd;
    }
    public String getPwd() {
	return pwd;
    }

	public void setName(String name) {
	this.name = name;
    }
    public String getName() {
	return name;
    }
}