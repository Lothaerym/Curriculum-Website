package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Administrator;

import com.example.demo.bean.Administrator;

import java.util.List;

import org.hibernate.*;

@Controller
public class AccueilController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		// test session
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
		
		/*
        Session sessiona = HibernateUtil.getSessionFactory().openSession();
        
        sessiona.beginTransaction();
 
        Administrator admin = new Administrator(1, "123", "thomas");
        sessiona.save(admin);
 
        sessiona.getTransaction().commit();
 
        Query q = sessiona.createQuery("From Administrator ");
                 
        List<Administrator> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Administrator next : resultList) {
            System.out.println("next employee: " + next);
        }
		*/
		
		return "pages/home";
	}
}
