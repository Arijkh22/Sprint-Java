/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class Publicite {
     private int id;
    private String nom_pub;
    private String description;
    private  String image;
    private int id_sponsor;

    public Publicite() {
    }

    public Publicite(int id, String nom_pub, String description, String image, int id_sponsor) {
        this.id = id;
        this.nom_pub = nom_pub;
        this.description = description;
        this.image = image;
        this.id_sponsor = id_sponsor;
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

    public int getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", nom_pub=" + nom_pub + ", description=" + description + ", image=" + image + ", id_sponsor=" + id_sponsor + '}';
    }
    
    
}
