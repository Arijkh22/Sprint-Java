/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.services;

import java.util.ArrayList;

/**
 *
 * @author omaim
 */
public interface PService<Reponse> {
    public abstract void AjouterReponse(Reponse t);
    public abstract void AjouterReponse2(Reponse t);
    public void suprrimerReponse(Reponse t);
    public void modifierReponse(Reponse t);
    public ArrayList<Reponse> afficherreponse();
    
}
