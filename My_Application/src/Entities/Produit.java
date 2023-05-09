/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Khedhira Arij
 */
public class Produit {
    
    private int id_produit;
    private String nom;
    private String description;
    private int quantite;
    private float prix;
    private Date date;
    private String photo;
    private int id_categorie;

    public Produit() {
    }

    public Produit(int id_produit, String nom, String description, int quantite, float prix, Date date, String photo, int id_categorie) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;
        this.photo = photo;
        this.id_categorie = id_categorie;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom=" + nom + ", description=" + description + ", quantite=" + quantite + ", prix=" + prix + ", date=" + date + ", photo=" + photo + ", id_categorie=" + id_categorie + '}';
    }
    
    
}
