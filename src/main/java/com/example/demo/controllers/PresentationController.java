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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Administrator;
import com.example.demo.bean.Presentation;

@Controller
public class PresentationController {
	 
    @RequestMapping(value="/editPres", method = RequestMethod.GET)
    public String editPresForm(Model model) {
        model.addAttribute("presentation", new Presentation());
        
    	return "form/presForm";
    }
    
    @RequestMapping(value="/editPres", method = RequestMethod.POST)
    public String login(@ModelAttribute Presentation presentation, Model model, HttpServletRequest request,  HttpSession session) {

    	model.addAttribute("presentation", new Presentation());
    	
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        
 
        Presentation pres = new Presentation(1, presentation.getName(), presentation.getJob(), presentation.getEmail(), presentation.getNumber(), presentation.getAddress(), presentation.getGithub(), presentation.getDescription());

        if(isAdmin == null) {
        	return "redirect:/login";
        }
    	session2.beginTransaction();
    	session2.update(pres);
        session2.getTransaction().commit();
   	 	session2.close();
        	return "redirect:/";

    }
	
}
