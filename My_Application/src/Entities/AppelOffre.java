/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class AppelOffre {
    public int id;
    public String nom,description;
    public float budget;
    public String quantite;
    public String date;
    public int idUtilisateur,idCategorie;

    public AppelOffre() {
    }

    public AppelOffre(int id, String nom, String description, float budget, String quantite, String date, int idUtilisateur, int idCategorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.budget = budget;
        this.quantite = quantite;
        this.date = date;
        this.idUtilisateur = idUtilisateur;
        this.idCategorie = idCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public String toString() {
        return "AppelOffre{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", budget=" + budget + ", quantite=" + quantite + ", date=" + date + ", idUtilisateur=" + idUtilisateur + ", idCategorie=" + idCategorie + '}';
    }

    

    
    
    
    
    
    
}
