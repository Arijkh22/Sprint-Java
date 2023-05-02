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
public class Publicite {
    int id ;
    
    String nom_pub;
    String description;
    String image;
    int id_sponsor_id ;

    public Publicite() {
    }

    public Publicite(int id, String nom_pub, String description, String image, int id_sponsor_id) {
        this.id = id;
        this.nom_pub = nom_pub;
        this.description = description;
        this.image = image;
        this.id_sponsor_id = id_sponsor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_pub() {
        return nom_pub;
    }

    public void setNom_pub(String nom_pub) {
        this.nom_pub = nom_pub;
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

    public int getId_sponsor_id() {
        return id_sponsor_id;
    }

    public void setId_sponsor_id(int id_sponsor_id) {
        this.id_sponsor_id = id_sponsor_id;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", nom_pub=" + nom_pub + ", description=" + description + ", image=" + image + ", id_sponsor_id=" + id_sponsor_id + '}';
    }
    
    
    
    
    
    
    
}
