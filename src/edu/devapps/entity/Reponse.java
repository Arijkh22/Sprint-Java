/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.entity;

/**
 *
 * @author omaim
 */
public class Reponse {
    
    int id;
    String nom;
    String budget;
    String Etat ;
    String date;
    int id_offre;

    public Reponse() {
    }

    public Reponse(int id, String nom, String budget, String Etat, String date, int id_offre) {
        this.id = id;
        this.nom = nom;
        this.budget = budget;
        this.Etat = Etat;
        this.date = date;
        this.id_offre = id_offre;
    }

    public Reponse(String nom, String budget, String Etat, String date, int id_offre) {
        this.nom = nom;
        this.budget = budget;
        this.Etat = Etat;
        this.date = date;
        this.id_offre = id_offre;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getBudget() {
        return budget;
    }

    public String getEtat() {
        return Etat;
    }

    public String getDate() {
        return date;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", nom=" + nom + ", budget=" + budget + ", Etat=" + Etat + ", date=" + date + ", id_offre=" + id_offre + '}';
    }
    
    
    
}
