/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface IService<T> {
    
    public abstract void AjouterPersonne(T t);
    public abstract void AjouterPersonne2(T t);
    public void suprrimerPersonne(T t);
    public void modifierPersonne(T t);
    public ArrayList<T> afficherpersonne();
    
    public ArrayList<T> rechercherpersonne(String champ);
    
    public ArrayList<T> rechercheavancee(String champ, String valeur);
    
}
