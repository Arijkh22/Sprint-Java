/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jihed;


import com.mysql.jdbc.Connection;
import edu.devapps.entity.Publicite;
import edu.devapps.entity.Sponsor;
import edu.devapps.services.PubliciteService;
import edu.devapps.services.SponsorService;
import java.sql.Date;



/**
 *
 * @author FAROUK
 */
public class Pidev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      
        Date d = new Date(1999, 10, 30);
         
        Publicite p = new Publicite(44, "teste", "teste", "teste", 19);
        PubliciteService s = new PubliciteService();
        System.out.println(s.afficherpublicite());
        
    }

   
    
}
