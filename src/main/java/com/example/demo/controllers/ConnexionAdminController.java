package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Administrator;

import org.hibernate.*;

@Controller
public class ConnexionAdminController {
	/*
    @GetMapping("/authentification")
    public String connectAdmin(Model model) {
        
        model.addAttribute("admin", new Administrator());
        return "pages/connexionAdmin";
    }
	
    
    @PostMapping("/verif")
    public String checkAdmin(@ModelAttribute Administrator admin, HttpServletRequest request, ModelMap modelMap) {

     //  	System.out.println("bonjour");
    	//System.out.println(admin.getName());
    	//System.out.println(admin.getPwd()); 
    	
    	request.getSession().setAttribute("isAdmin?", true);
    	
    	// TODO: verif le nom et le mot de passe  + créer une session si verif = true 
    	
        // TODO: NB : save project in DB here for others forms
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Query q = session.createQuery("From Administrator ");
    	List<Administrator> resultList = q.list();
    	
        for (Administrator next : resultList) {
            if(next.getName().equals(admin.getName())) {
            	modelMap.put("adminName", admin.getName());
            };
        }
    	
        return "pages/bienvenue";
    }
    
    */
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("admin", new Administrator());
    	return "pages/connexionAdmin";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute Administrator admin, Model model) {

    	model.addAttribute("admin", new Administrator());
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Query q = session.createQuery("From Administrator ");
    	List<Administrator> resultList = q.list();
    	
        for (Administrator next : resultList) {
            if(next.getName().equals(admin.getName()) && next.getPwd().equals(admin.getPwd())) {
            	model.addAttribute("adminName", admin.getName());
            	return "pages/bienvenue";
            };
        }
        model.addAttribute("invalidCredentials", true);
        return "pages/connexionAdmin";
    }
}

