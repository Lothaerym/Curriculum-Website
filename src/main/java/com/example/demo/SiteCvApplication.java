package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.Administrator;
import com.example.demo.bean.Competence;
import com.example.demo.bean.Experience;
import com.example.demo.bean.Formation;
import com.example.demo.bean.Presentation;

import java.util.List;

import org.hibernate.*;


@SpringBootApplication
public class SiteCvApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SiteCvApplication.class, args);
		
		// Jeu de données 
        Session sessiona = HibernateUtil.getSessionFactory().openSession();
        
        sessiona.beginTransaction();
 
        Administrator admin = new Administrator(1, "123", "thomas");
        sessiona.save(admin);
        
        Presentation presentation = new Presentation (1, "Thomas DELHAYE", "Développeur J2EE - PHP", "thomas.del.haye@outlook.fr", "06 68 97 83 93", "29 rue Jean Jaurès, Raismes ", "https://github.com/Lothaerym", "lorem ipsum" );
        sessiona.save(presentation);
        
        Formation form = new Formation(1, "Master Technologies Nouvelles des Systèmes d'Information (TNSI)", "2017 - 2019", "Université de Valenciennes", "Institut des Sciences et Techniques de Valenciennes </br> Université de Valenciennes et du Hainaut-Cambrésis");
        sessiona.save(form);
        form = new Formation(2, "Licence Informatique", "2014 - 2017", "Université de Valenciennes", "Institut des Sciences et Techniques de Valenciennes </br> Université de Valenciennes et du Hainaut-Cambrésis");
        sessiona.save(form);
        form = new Formation(3, "Première Année Commune aux Etudes de Santé (PACES)", "2013 - 2014", "Faculté de Médecine Henri Warenbourg", "Université Lille 2");
        sessiona.save(form);
        form = new Formation(4, "Baccalauréat Scientifique", "2013", "Lycée Henri Wallon, Valenciennes", "Mention Assez Bien");
        sessiona.save(form);

        Experience expe = new Experience(1, "DSI Orange", "Villeneuve d'Ascq </br> Groupe Orange", "Mars - Août 2019", "Stage de développement PHP/MySQL </br> Orange Framework Tools, Symfony, Zend </br> QlikSense, Git, Methode Agile (Jira) </br></br> 6 mois");
        sessiona.save(expe);
        expe = new Experience(2, "Mairie de Rosult", "Rosult", "Avril - Mai 2017", "Stage Développement Web </br> WordPress </br></br> 6 semaines");
        sessiona.save(expe);
        
        Competence comp = new Competence(1, "C </br> Java </br> PHP </br> Ruby </br> JavaScript", "SQL </br> QlikSense", "Symfony </br> Zend </br> RubyOnRails </br> AngularJS </br> Spring MVC / Hibernate / Thymeleaf", "HTML / CSS </br> WordPress </br> Shell");
        sessiona.save(comp);
 
        sessiona.getTransaction().commit();
   	 	sessiona.close();
	}

}
