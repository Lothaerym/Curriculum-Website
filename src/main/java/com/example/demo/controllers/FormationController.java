package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Formation;
import com.example.demo.bean.Presentation;

@Controller
public class FormationController {

	@GetMapping("/formation")
	public String formation(Model model, HttpSession session) {
		
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		model.addAttribute("isadmin", isAdmin );
		
        Session session2 = HibernateUtil.getSessionFactory().openSession();      
        session2.beginTransaction();
        Query q = session2.createQuery("From Formation ");
        
        List<Formation> resultList = q.list();
        
        model.addAttribute("resultList", resultList);
        
        List<Presentation> pres = getPres();
   	 	model.addAttribute("presName", pres.get(0).getName());
   	 	model.addAttribute("presJob", pres.get(0).getJob());
   	 	model.addAttribute("presEmail", pres.get(0).getEmail());
   	 	model.addAttribute("presNumber", pres.get(0).getNumber());
   	 	model.addAttribute("presAddress", pres.get(0).getAddress());
   	 	model.addAttribute("presGithub", pres.get(0).getGithub());

   	 	
   	 	
		return "pages/formation";
	}
	
	public List<Presentation> getPres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Presentation where id=1 ");
        List<Presentation> resultList = q.list();
        return resultList;
	}
	
}
