package hamma;



import edu.devapps.entity.Categorie;
import edu.devapps.entity.Facture;
import edu.devapps.entity.Finance;
import edu.devapps.entity.Produit;
import edu.devapps.entity.Publicite;
import edu.devapps.entity.Reclamation;
import edu.devapps.entity.Reponse_rec;
import edu.devapps.entity.Sponsor;
import edu.devapps.entity.Utilisateur;


public interface MyListener {
  
    public void onClickListener(Utilisateur Utilisateur);

       public void onClickListener(Reclamation Reclamation);

    public void onClickListener(Reponse_rec Reponse_rec);
     public void onClickListener(Sponsor Sponsor);

    public void onClickListener(Publicite Publicite);
        public void onClickListener(Categorie Categorie);

    public void onClickListener(Produit Produit);
        public void onClickListener(Facture Facture);

    public void onClickListener(Finance Finance);
}
