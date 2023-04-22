
package arij;


import com.mysql.jdbc.Connection;
import edu.devapps.entity.Categorie;
import edu.devapps.entity.Produit;
import edu.devapps.services.CategorieService;
import edu.devapps.services.ProduitService;

import java.sql.Date;


public class Pidev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      
        Date d = new Date(1999, 10, 30);
         
   Produit p = new Produit(82, "test2", "test2", 202, 202, "test2", d, 26);
            
   ProduitService s = new ProduitService();
        System.out.println(s.afficherproduit());
    }

   
    
}
