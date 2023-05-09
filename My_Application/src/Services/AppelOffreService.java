/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.AppelOffre;
import com.codename1.components.ToastBar;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.AppelOffreForm;
import com.mycompany.myapp.AppelOffresearchForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class AppelOffreService {
    public static AppelOffre currentBac=new AppelOffre();
    
   
    public ArrayList<AppelOffre> getAllOffres() {
         
        ArrayList<AppelOffre> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/afficheroffreejSON");
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
                        AppelOffre apl = new AppelOffre();
                       
                        apl.setNom(obj.get("nom").toString());
                        apl.setQuantite(obj.get("quantite").toString());
                        apl.setBudget(Float.parseFloat(obj.get("budget").toString()));
                        apl.setDescription(obj.get("description").toString());
                        apl.setDate(obj.get("date").toString());
                        apl.setIdUtilisateur(((int)(double)obj.get("idU")));
                        apl.setIdCategorie(((int)(double)obj.get("idCa")));
                        apl.setId(((int)(double)obj.get("id")));
                    
                        listTasks.add(apl);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
 
       
     public void getAllOffres(Resources res,String s) {
         
        ArrayList<AppelOffre> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/searchededoffrejson?search="+s);
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
                        AppelOffre apl = new AppelOffre();
                       
                        apl.setNom(obj.get("nom").toString());
                        apl.setQuantite(obj.get("quantite").toString());
                        apl.setBudget(Float.parseFloat(obj.get("budget").toString()));
                        apl.setDescription(obj.get("description").toString());
                        apl.setDate(obj.get("date").toString());
                        apl.setIdUtilisateur(((int)(double)obj.get("idU")));
                        apl.setIdCategorie(((int)(double)obj.get("idCa")));
                        apl.setId(((int)(double)obj.get("id")));
                    
                        listTasks.add(apl);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         new  AppelOffresearchForm(res,s).show();
    }
     
    
    
    
    
    
    
    
     /***************************************************************************/
     public void register(Resources res,AppelOffre u){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerOffre?nom="+u.getNom()+
               "&quantite="+u.getQuantite()+
               "&budget="+u.getBudget()+
               "&description="+u.getDescription()
                +"&idUtilisateur="+u.getIdUtilisateur()
                +"&idCategorie="+u.getIdCategorie();
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

                        currentBac.setId((int)((double) tasks.get("idAppelOffre")));
                         
                        }
                        catch(ArrayIndexOutOfBoundsException exs)
                        {
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);
                     
                    status.setMessage("no appel Offre found");
                    status.setExpires(2000);
                    status.show();
                        return ;
                        }
                } catch (IOException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);
                     
                    status.setMessage("no internet.... ");
                    status.setExpires(3000);
                     
                }
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
            NetworkManager.getInstance().addToQueueAndWait(r);
            new  AppelOffreForm(res).show();
             
         
     }
    
     
     
     
     
      public void retour(Resources res){
       new  AppelOffreForm(res).show();
              
         
     }
    
     public void update(Resources res ,AppelOffre u){
          
            System.out.println(u.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateOffre?id="+u.getId()+
                  "&nom="+u.getNom()+
                  "&quantite="+u.getQuantite()+
                  "&budget="+u.getBudget()+
                  "&description="+u.getDescription()+
                  "&date="+u.date+
                  "idUtilisateur"+u.getIdUtilisateur()+
                  "idCategorie"+u.getIdCategorie();
            r.setUrl(url);
        
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new AppelOffreForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new AppelOffreForm(res).show();

             
            }
            
     }

