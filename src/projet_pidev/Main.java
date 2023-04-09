package projet_pidev;
import entities.Categorie;
import entities.Produit;
import services.ServiceCategorie;
import services.ServiceProduit;


/**
 *
 * @author Khedhira Arij
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        ServiceCategorie sc = new ServiceCategorie();
        ServiceProduit sp = new ServiceProduit();

       //  Categorie c1 =new Categorie(34,"Accesso");
        //  Categorie c2 =new Categorie(18,"Accessoires");
        // Categorie c2 =new Categorie(29,"Bu");
        // Categorie c3 =new Categorie(31,"bbbbb");
        // Categorie c4 =new Categorie("bbbbb");
        // Categorie c5 =new Categorie("bbbbb");
        //  sc.update(c1);
        //   sc.add_categorie(c1);
        // sc.delete_categorie(c1);

       // Produit p1 = new Produit("chaise", "chaise blanc ", 700, (float) 25.15,"image.jpg", 28);
       // Produit p2= new Produit("chaiseee", "chaise rouge", 1000, (float) 25.15,"image.jpg", 28);
       // Produit p3= new Produit(14,"table", "table", 178880, (float)175.5,"img2.jpg", 35);
       // Produit p6= new Produit(14,"table", "table", 178880, (float)175.5,"img2.jpg", 35);
        Produit p7= new Produit(14,"fffff", "ff", 1111, (float)11111.5,"image.jpg", 35);

       // sp.add_produit(p7);
       // sp.updateProduit(p7);
       // sp.deleteProduit(100);
    }    
    
    
}

                  
    
    
