package dao;

import java.util.List;

import model.Etudiant;

public interface IEtudiantDAO {
public int creat (Etudiant eu);
public int remove (int ide);
public int update (Etudiant eu);
public List<Etudiant> afficheEtudiant(int ide);
public List<Etudiant> getEtudiants();
}
