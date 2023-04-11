/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshoppidev3a50;

import workshop.entities.Personne;
import workshop.services.ServicePersonne;
import workshop.test.A;
import workshop.utils.MyDB;

/**
 *
 * @author Andrew
 */
public class WorkshopPidev3A50 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
        MyDB.getInstance();
        
        Personne p1 =new Personne("pc", "2", "120", "nouvvv","20-1-2023",1,1);
        Personne p2 =new Personne("pc", "20", "150", "nouvvv","20-1-2023",1,1);
        
        
        ServicePersonne sp = new ServicePersonne();
        sp.AjouterPersonne(p1);
        sp.AjouterPersonne2(p2);
        
        System.out.println(sp.afficherpersonne());
        
        
        
        
        
    }
    
}
