package dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import model.Etudiant;


@Repository
public class EtudiantDAO implements IEtudiantDAO{
	SessionFactory factory= new Configuration().configure().buildSessionFactory();
	Session session =factory.openSession();
	public int creat(Etudiant eu) {
		
	try {
			
			session.beginTransaction();
			session.saveOrUpdate(eu);
			session.getTransaction().commit();
			session.close();
			return 1;
			
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return 0;
	}

}
	

	public int remove(int ide) {
	try {
			Etudiant et = new Etudiant();
			et.setIdEtudiant(ide);
			session.beginTransaction();
			session.delete(et);
			session.getTransaction().commit();
			session.close();
			return 1;
			
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return 0;
	}

}
	public int update(Etudiant eu) {
try {
			
			session.beginTransaction();
			String request="update Etudiant SET "+"nom= :nom"+" prenom= :prenom" +"groupe= :groupe"+"  where idEtudiant= :idEtudiant";
			Query query= session.createQuery(request);
			query.setParameter("nom", eu.getNom());
			query.setParameter("prenom", eu.getPrenom());
			query.setParameter("groupe", eu.getGroupe());
			query.setParameter("idEtudiant", eu.getIdEtudiant());
			session.getTransaction().commit();
			session.close();
			return 1;
			
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return 0;
	}

}
	

	public List<Etudiant> afficheEtudiant(int ide) {
		List<Etudiant> form= new ArrayList<Etudiant>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Etudiant where idEtudiant= :idetu");
			query.setParameter("idetu", ide).list();
			form=query.list();
			session.close();
			return form;
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return null;
			}
	}
	
	public List<Etudiant> getEtudiants() {
		List<Etudiant> form= new ArrayList<Etudiant>();
		try {
			session.beginTransaction();
			Query query = session.createQuery( "from Etudiant");
			form=query.list();
			session.close();
			return form;
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return null;
			}
	}
	
	
	
	
}
