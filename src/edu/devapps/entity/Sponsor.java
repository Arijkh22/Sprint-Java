/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.entity;

/**
 *
 * @author THEOLDISBACK
 */
public class Sponsor {
    int id;
    String nom;
    String adresse;
    String email;
    int num_tel;

    public Sponsor() {
    }

    public Sponsor(int id, String nom, String adresse, String email, int num_tel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "Sponsor{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", email=" + email + ", num_tel=" + num_tel + '}';
    }
    
    
    
    
    
    
    
    
}
