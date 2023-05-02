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
public class Rating {
    int  id ;
    int rate;
    int iduser ;
    int idpub ;

    public Rating() {
    }

    public Rating(int id, int rate, int iduser, int idpub) {
        this.id = id;
        this.rate = rate;
        this.iduser = iduser;
        this.idpub = idpub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpub() {
        return idpub;
    }

    public void setIdpub(int idpub) {
        this.idpub = idpub;
    }

    @Override
    public String toString() {
        return "Rating{" + "id=" + id + ", rate=" + rate + ", iduser=" + iduser + ", idpub=" + idpub + '}';
    }
    
    
    
    
    
    
    
}
