package service;

import java.util.List;

import model.Etudiant;

public interface IEtudiantServive {
public List<Etudiant> getEtudiants();
public int supprimer(int ide);
public int ajouter (Etudiant etu);
public List<Etudiant> getEtudiant(int ide);
}
