package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.Administrator;

import java.util.List;

import org.hibernate.*;


@SpringBootApplication
public class SiteCvApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SiteCvApplication.class, args);
		
	}

}
