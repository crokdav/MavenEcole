package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.IEtudiantDAO;

import model.Etudiant;

@Service
public class EtudiantService implements IEtudiantServive {
	@Autowired
	private IEtudiantDAO dao;
	
	
	
	public void setDao(IEtudiantDAO dao) {
		this.dao = dao;
	}

	public List<Etudiant> getEtudiants() {
		
		return dao.getEtudiants();
	}

	public int supprimer(int ide) {
		return dao.remove(ide);
	}

	public int ajouter(Etudiant etu) {
		return dao.creat(etu);
	}

	public List<Etudiant> getEtudiant(int ide) {
		
		return dao.afficheEtudiant(ide);
	}

}
