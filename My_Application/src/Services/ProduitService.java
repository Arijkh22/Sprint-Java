
package Services;

import Entities.Produit;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.ProduitsForm;
import com.mycompany.myapp.ProduitssearchForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


/**
 *
 * @author Khedhira Arij
 */
public class ProduitService {
    public static Produit currentProduit=new Produit();
     public ArrayList<Produit> getAllProducts() {
        ArrayList<Produit> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Produitlistjson");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Produit produit = new Produit();
                        produit.setDescription(obj.get("description").toString());
                        produit.setNom(obj.get("nomProduit").toString());
                        produit.setPrix( ((int)(double) obj.get("prix")));
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setQuantite( ((int)(double) obj.get("quantite")));
                        produit.setId_produit( ((int)(double) obj.get("idProduit")));
                        produit.setId_categorie( ((int)(double) obj.get("ide")));
                        
                        listTasks.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
  
     
      public void getAllProductssearch(Resources res,String s) {
        ArrayList<Produit> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/searchedjsonprod?search="+s);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Produit produit = new Produit();
                        produit.setDescription(obj.get("description").toString());
                        produit.setNom(obj.get("nomProduit").toString());
                        produit.setPrix( ((int)(double) obj.get("prix")));
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setQuantite( ((int)(double) obj.get("quantite")));
                        produit.setId_produit( ((int)(double) obj.get("idProduit")));
                        produit.setId_categorie( ((int)(double) obj.get("ide")));
                        
                        listTasks.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
          new ProduitssearchForm(res,s) .show();
    }

     
     /***************************************************************************/
     public void register(Resources res,Produit p){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/addProduitjson?nomProduit="+p.getNom()+
               "&description="+p.getDescription()+
               "&prix="+p.getPrix()+
               "&quantite="+p.getQuantite()+
               "&photo="+p.getPhoto()+
               "&idCategorie="+p.getId_categorie();
            r.setUrl(url);
            r.setPost(true);
            r.addArgument("encoding", "json");
            r.setContentType("application/json");
            r.addResponseListener(resp -> {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(r.getResponseData()).toCharArray()));
                    System.out.println("tasks :"+tasks);
                        try{
                        currentProduit.setId_produit((int)((double) tasks.get("idProduit")));
                        }
                        catch(ArrayIndexOutOfBoundsException exs)
                        {
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);                    
                    status.setMessage("aucun produit trouvé");
                    status.setExpires(2000);
                    status.show();
                        return ;
                        }
                } catch (IOException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);                   
                    status.setMessage("pas d'internet.... ");
                    status.setExpires(3000);  
                }
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("en cours.... ");
            status.show();
            NetworkManager.getInstance().addToQueueAndWait(r);
            new  ProduitsForm(res).show();
     }
    
     public void update(Resources res ,Produit p){
          
            System.out.println(p.getId_produit());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateProduit?id="+p.getId_produit()+
               "&nomProduit="+p.getNom()+
               "&description="+p.getDescription()+
               "&prix="+p.getPrix()+
               "&quantite="+p.getQuantite();
            r.setUrl(url);
            r.setPost(true);
            r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new ProduitsForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("en cours.... ");
            status.show();
         new ProduitsForm(res).show();

             
             
            }
}
