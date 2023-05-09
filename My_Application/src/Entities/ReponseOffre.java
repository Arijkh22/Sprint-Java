/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class ReponseOffre {
    private int id;
    private String nom_produit;
    private float budget;
    private String etat;
    private String date;
    private int idOffre;

    public ReponseOffre() {
    }

    public ReponseOffre(int id, String nom_produit, float budget, String etat, String date, int idOffre) {
        this.id = id;
        this.nom_produit = nom_produit;
        this.budget = budget;
        this.etat = etat;
        this.date = date;
        this.idOffre = idOffre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public String toString() {
        return "ReponseOffre{" + "id=" + id + ", nom_produit=" + nom_produit + ", budget=" + budget + ", etat=" + etat + ", date=" + date + ", idOffre=" + idOffre + '}';
    }
    
    
    
}
