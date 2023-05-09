
package Services;
import Entities.Categorie;
import com.codename1.components.ToastBar;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.CategoriesForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CategorieService {
    public static Categorie currentCategorie=new Categorie();
     public ArrayList<Categorie> getAllCategories() {
        ArrayList<Categorie> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Categorielistjson");
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
                        Categorie categorie = new Categorie();
                        categorie.setNom(obj.get("nom").toString());
                        categorie.setId( ((int)(double) obj.get("id")));                      
                        listTasks.add(categorie);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
      
     /***************************************************************************/
     public void register(Resources res,Categorie c){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                String url =  "http://127.0.0.1:8000/addCategoriejson?nomcategorie="+c.getNom()+
               "&id="+c.getId()+
               "&nomcategorie="+c.getNom();
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

                        currentCategorie.setId((int)((double) tasks.get("id")));  
                        }
                        catch(ArrayIndexOutOfBoundsException exs)
                        {
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);                    
                    status.setMessage("aucune categorie trouvée");
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
            new  CategoriesForm(res).show();   
     }
    
     public void update(Resources res ,Categorie c){
          
            System.out.println(c.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateCategorie?id="+c.getId()+
               "&nomcategorie="+c.getNom();
               
            r.setUrl(url);
            r.setPost(true);
            r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new CategoriesForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("en cours.... ");
            status.show();
         new CategoriesForm(res).show();

             
             
            }
                  
 
    
    
     }

