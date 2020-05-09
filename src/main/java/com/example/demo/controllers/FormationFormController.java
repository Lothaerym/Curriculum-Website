package com.example.demo.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Administrator;
import com.example.demo.bean.Formation;
import com.example.demo.bean.Presentation;

@Controller
public class FormationFormController {
	 
    @RequestMapping(value="/createFormation", method = RequestMethod.GET)
    public String createFormation(Model model) {
        model.addAttribute("formation", new Formation());
        
    	return "form/formationForm";
    }
    
    @RequestMapping(value="/createFormation", method = RequestMethod.POST)
    public String createFormation(@ModelAttribute Formation formation, Model model, HttpServletRequest request,  HttpSession session) {

    	model.addAttribute("formation", new Formation());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
 
        Formation forma = new Formation(1, formation.getTitle(), formation.getDate(), formation.getSchool(), formation.getDescription());

        if(isAdmin == null) {
        	return "redirect:/login";
        }
    	session2.beginTransaction();
    	session2.save(forma);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/formation";

    }
    
    @RequestMapping(value="/editFormation/{id}", method = RequestMethod.GET)
    public String editFormation(Model model, @PathVariable int id) {
        model.addAttribute("formation", new Formation());
        model.addAttribute("id", id);
        
    	return "form/editFormationForm";
    }

    @RequestMapping(value="/editFormation/{id}", method = RequestMethod.POST)
    public String editFormation(@ModelAttribute Formation formation, Model model, HttpServletRequest request,  HttpSession session, @PathVariable int id) {

    	model.addAttribute("formation", new Formation());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
 
        // Formation forma = new Formation(id, formation.getTitle(), formation.getDate(), formation.getSchool(), formation.getDescription());

        if(isAdmin == null) {
        	return "redirect:/login";
        }
    	session2.beginTransaction();
    	Formation formaLoad = (Formation) session2.load(Formation.class, id);
    	formaLoad.setTitle(formation.getTitle());
    	formaLoad.setDate(formation.getDate());
    	formaLoad.setSchool(formation.getSchool());
    	formaLoad.setDescription(formation.getDescription());
    	
    	session2.update(formaLoad);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/formation";

    }
}