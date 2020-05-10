package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Administrator;
import com.example.demo.bean.Competence;
import com.example.demo.bean.Formation;
import com.example.demo.bean.Presentation;
import com.example.demo.bean.Administrator;

import java.util.List;

import org.hibernate.*;

@Controller
public class AccueilController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		
		// test session
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		model.addAttribute("isadmin", isAdmin );

		
		//session.removeAttribute("isAdmin?");		

   	 	
        List<Presentation> pres = getPres();
   	 	model.addAttribute("presName", pres.get(0).getName());
   	 	model.addAttribute("presJob", pres.get(0).getJob());
   	 	model.addAttribute("presEmail", pres.get(0).getEmail());
   	 	model.addAttribute("presNumber", pres.get(0).getNumber());
   	 	model.addAttribute("presAddress", pres.get(0).getAddress());
   	 	model.addAttribute("presGithub", pres.get(0).getGithub());
   	 	model.addAttribute("presDescription", pres.get(0).getDescription());
        /*
        Query q = sessiona.createQuery("From Administrator ");
                 
        List<Administrator> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Administrator next : resultList) {
            System.out.println("next employee: " + next);
        }
        
		*/
        
		
		return "pages/home";
	}
	
	public List<Presentation> getPres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Presentation where id=1 ");
        List<Presentation> resultList = q.list();
        return resultList;
	}
}
