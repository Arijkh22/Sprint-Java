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
public class Utilisateur {
    int id ;
    int key=5;
    String nom;
    String prenom;
    String password;
    String email;
    String adresse;
    String role;
    Date age;
    String username;
    String photo;
    int bloquer;
    int code;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String password, String email, String adresse, String role, Date age, String username, String photo, int bloquer, int code) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.adresse = adresse;
        this.role = role;
        this.age = age;
        this.username = username;
        this.photo = photo;
        this.bloquer = bloquer;
        this.code = code;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getBloquer() {
        return bloquer;
    }

    public void setBloquer(int bloquer) {
        this.bloquer = bloquer;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", email=" + email + ", adresse=" + adresse + ", role=" + role + ", age=" + age + ", username=" + username + ", photo=" + photo + ", bloquer=" + bloquer + ", code=" + code + '}';
    }
    
    
    
    
     public String encrypt (String text)
    {
        String altern="";
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c+=this.key;
            altern+=c;
        }
        return altern;
    }
    public String decrypt (String text)
    {
                String altern="";

       
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c-=this.key;
            altern+=c;
        }
       
        return altern;
    }
    
    
    
    
}
