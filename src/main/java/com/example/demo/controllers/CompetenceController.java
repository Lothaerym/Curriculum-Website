package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.HibernateUtil;
import com.example.demo.bean.Competence;
import com.example.demo.bean.Formation;
import com.example.demo.bean.Presentation;

@Controller
public class CompetenceController {

	@GetMapping("/competence")
	public String competence(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		model.addAttribute("isadmin", isAdmin );		
        Session sessiona = HibernateUtil.getSessionFactory().openSession();
        sessiona.beginTransaction();

        Query q = sessiona.createQuery("From Competence ");
        
        List<Competence> resultList = q.list();
        model.addAttribute("compProg", resultList.get(0).getProgrammation());
        model.addAttribute("compData", resultList.get(0).getData());
        model.addAttribute("compFram", resultList.get(0).getFrameworks());
        model.addAttribute("compAutres", resultList.get(0).getAutres());

        List<Presentation> pres = getPres();
   	 	model.addAttribute("presName", pres.get(0).getName());
   	 	model.addAttribute("presJob", pres.get(0).getJob());
   	 	model.addAttribute("presEmail", pres.get(0).getEmail());
   	 	model.addAttribute("presNumber", pres.get(0).getNumber());
   	 	model.addAttribute("presAddress", pres.get(0).getAddress());
   	 	model.addAttribute("presGithub", pres.get(0).getGithub());
   	 	model.addAttribute("presDescription", pres.get(0).getDescription());
   	 	
		return "pages/competence";
	}
	
	public List<Presentation> getPres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Presentation where id=1 ");
        List<Presentation> resultList = q.list();
        return resultList;
	}
}