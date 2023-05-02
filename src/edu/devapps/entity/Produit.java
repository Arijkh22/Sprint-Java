/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.entity;

import java.sql.Date;


public class Produit {
    
    int id_produit ;
    String nom_produit;
    String description;
    float prix;
    int quantite;
    String photo;
    Date date;
    int id_categorie_id ;
    float rate;

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }

    public Produit() {
    }

    public Produit(int id_produit, String nom_produit, String description, float prix, int quantite, String photo, Date date, int id_categorie_id) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.photo = photo;
        this.id_categorie_id = id_categorie_id;
        this .date = date;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

  

    public int getId_categorie_id() {
        return id_categorie_id;
    }

    public void setId_categorie_id(int id_categorie_id) {
        this.id_categorie_id = id_categorie_id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", photo=" + photo + ", date=" + date + ", id_categorie_id=" + id_categorie_id + '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
