package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Experience;

@Controller
public class ExperienceFormController {
    @RequestMapping(value="/createExperience", method = RequestMethod.GET)
    public String createFormation(Model model) {
        model.addAttribute("experience", new Experience());
        
    	return "form/experienceForm";
    }
    
    @RequestMapping(value="/createExperience", method = RequestMethod.POST)
    public String createFormation(@ModelAttribute Experience experience, Model model, HttpServletRequest request,  HttpSession session) {

    	model.addAttribute("experience", new Experience());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
 
        Experience expe = new Experience(1, experience.getEmployer(), experience.getAdress(), experience.getDate(), experience.getDescription());

        if(isAdmin == null) {
        	return "redirect:/login";
        }
    	session2.beginTransaction();
    	session2.save(expe);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/experience";

    }
    
    @RequestMapping(value="/editExperience/{id}", method = RequestMethod.GET)
    public String editFormation(Model model, @PathVariable int id) {
        model.addAttribute("experience", new Experience());
        model.addAttribute("id", id);
        
    	return "form/editExperienceForm";
    }

    @RequestMapping(value="/editExperience/{id}", method = RequestMethod.POST)
    public String editFormation(@ModelAttribute Experience formation, Model model, HttpServletRequest request,  HttpSession session, @PathVariable int id) {

    	model.addAttribute("experience", new Experience());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
        if(isAdmin == null) {
        	return "redirect:/login";
        }
        
    	session2.beginTransaction();
    	Experience expeLoad = (Experience) session2.load(Experience.class, id);
    	expeLoad.setEmployer(formation.getEmployer());
    	expeLoad.setAdress(formation.getAdress());
    	expeLoad.setDate(formation.getDate());
    	expeLoad.setDescription(formation.getDescription());
    	
    	session2.update(expeLoad);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/experience";

    }
}
