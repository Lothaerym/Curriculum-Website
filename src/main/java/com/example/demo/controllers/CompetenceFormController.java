package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Competence;

@Controller
public class CompetenceFormController {

    @RequestMapping(value="/editComp", method = RequestMethod.GET)
    public String editPresForm(Model model) {
        model.addAttribute("competence", new Competence());
        
    	return "form/EditCompetence";
    }
    
    @RequestMapping(value="/editComp", method = RequestMethod.POST)
    public String login(@ModelAttribute Competence competence, Model model, HttpServletRequest request,  HttpSession session) {

    	model.addAttribute("competence", new Competence());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
 
        Competence comp = new Competence(1, competence.getProgrammation(), competence.getData(), competence.getFrameworks(), competence.getAutres());

        if(isAdmin == null) {
        	return "redirect:/login";
        }
    	session2.beginTransaction();
    	session2.update(comp);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/competence";

    }
    
}
