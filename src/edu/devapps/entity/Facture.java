/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.entity;

import java.sql.Date;

/**
 *
 * @author THEOLDISBACK
 */
public class Facture {
    
        
    int id_facture ;
    int numero;
    String nom;
    float prix;
    Date date;
    String etat;
    String description;
    String image;
    int id_utilisateur;

    public Facture() {
    }

    public Facture(int id_facture, int numero, String nom, float prix, Date date, String etat, String description, String image, int id_utilisateur) {
        this.id_facture = id_facture;
        this.numero = numero;
        this.nom = nom;
        this.prix = prix;
        this.date = date;
        this.etat = etat;
        this.description = description;
        this.image = image;
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", numero=" + numero + ", nom=" + nom + ", prix=" + prix + ", date=" + date + ", etat=" + etat + ", description=" + description + ", image=" + image + ", id_utilisateur=" + id_utilisateur + '}';
    }
    
    
    
}
