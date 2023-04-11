/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.entities;


/**
 *
 * @author Andrew
 */
public class Personne {
    int id ; 
    String nom ;
    String quantite;
    String budget;
    String descrition;
    String date;
    int idUtilisateur;
    int idCategorie;
    
    
    public Personne(){}

    public Personne(int id, String nom, String quantite, String budget, String descrition, String date, int idUtilisateur, int idCategorie) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.budget = budget;
        this.descrition = descrition;
        this.date = date;
        this.idUtilisateur = idUtilisateur;
        this.idCategorie = idCategorie;
    }

    public Personne(String nom, String quantite, String budget, String descrition, String date, int idUtilisateur, int idCategorie) {
        this.nom = nom;
        this.quantite = quantite;
        this.budget = budget;
        this.descrition = descrition;
        this.date = date;
        this.idUtilisateur = idUtilisateur;
        this.idCategorie = idCategorie;
    }

    public Personne(String nom, String quantite, String budget, String descrition, String date) {
        this.nom = nom;
        this.quantite = quantite;
        this.budget = budget;
        this.descrition = descrition;
        this.date = date;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getBudget() {
        return budget;
    }

    public String getDescrition() {
        return descrition;
    }

    public String getDate() {
        return date;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdUtilisateur(int idUJtilisateur) {
        this.idUtilisateur = idUJtilisateur;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public String toString() {
        return "nom=" + nom + ", quantite=" + quantite + ", budget=" + budget + ", descrition=" + descrition + ", date=" + date;
    }

    
    
    
    
   
    
    

}