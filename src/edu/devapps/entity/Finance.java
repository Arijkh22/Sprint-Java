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
public class Finance {
    
int id;
float taxe;
int tva;
String 	photo;
float prix;
String 	etat;
Date 	date;

int 	id_facture;

    public Finance() {
    }

    public Finance(int id, float taxe, int tva, String photo, float prix, String etat, Date date, int id_facture) {
        this.id = id;
        this.taxe = taxe;
        this.tva = tva;
        this.photo = photo;
        this.prix = prix;
        this.etat = etat;
        this.date = date;
        this.id_facture = id_facture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTaxe() {
        return taxe;
    }

    public void setTaxe(float taxe) {
        this.taxe = taxe;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    @Override
    public String toString() {
        return "Finance{" + "id=" + id + ", taxe=" + taxe + ", tva=" + tva + ", photo=" + photo + ", prix=" + prix + ", etat=" + etat + ", date=" + date + ", id_facture=" + id_facture + '}';
    }

    
    
    
    
}
