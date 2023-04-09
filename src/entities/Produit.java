/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author Khedhira Arij
 */
public class Produit {
    int id_produit;
    String nom_produit;
    String description;
    int quantite;
    float prix;
    String photo;
    int id_categorie_id;

    public Produit() {
    }

    public Produit(int id_produit, String nom_produit, String description, int quantite, float prix, String photo, int id_categorie_id) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.photo = photo;
        this.id_categorie_id = id_categorie_id;
    }

    public Produit(String nom_produit, String description, int quantite, float prix, String photo, int id_categorie_id) {
        this.nom_produit = nom_produit;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.photo = photo;
        this.id_categorie_id = id_categorie_id;
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
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", description=" + description + ", quantite=" + quantite + ", prix=" + prix + ", photo=" + photo + ", id_categorie_id=" + id_categorie_id + '}';
    }


    
   

    
}
