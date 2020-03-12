package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import model.Etudiant;
import service.IEtudiantServive;

public class Main {

	public static void main(String[] args) {
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("ApplicationContext.xml");
		
				//IEtudiantServive service =   (IEtudiantServive) context.getBean("etudiantservice");
				//service.ajouter();
				//service.supprimer();
				
				//System.out.println(service.getEtudiants());
//				System.out.println(service.getEtudiant());
				
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
			c.scan("dao");
			c.scan("service");
			c.refresh();
			IEtudiantServive service =   (IEtudiantServive) c.getBean("etudiantService");
			service.ajouter(new Etudiant("Kalistos", "Cal", 7));
			System.out.println(service.getEtudiants());
	}

}
