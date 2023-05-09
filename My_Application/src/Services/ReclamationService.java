/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
import Entities.Utilisateur;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.ReclamationsForm;
import com.codename1.io.CharArrayReader;
import com.mycompany.myapp.ReclamationssearchForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;



public class ReclamationService {
    public static Reclamation currentrec=new Reclamation();
    
     public ArrayList<Reclamation> getAllReclamation() {
        ArrayList<Reclamation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Reclamationlist");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Reclamation reclamation = new Reclamation();
                        /*if (obj.get("image")!=null)*/
                        reclamation.setDescription(obj.get("description").toString());
                        reclamation.setEmail(obj.get("email").toString());
                        reclamation.setSujet(obj.get("sujet").toString());
                        reclamation.setId_rec((((int)(double) obj.get("idRec"))));
                       Utilisateur u = new Utilisateur();
                        System.out.println( obj.get("idUtilisateur") );
                        Map<String, Object> idUtilisateur = (Map<String, Object>) obj.get("idUtilisateur");
                    int id = (int) (double) idUtilisateur.get("id");
                      u.setId(id);
                      reclamation.setId_utilisateur_id(u);
                  
                        reclamation.setEtat((( obj.get("etat").toString())));
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(reclamation);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
      public void search(Resources res,String s) {
        ArrayList<Reclamation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/searchededjson?search="+s);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Reclamation reclamation = new Reclamation();
                        /*if (obj.get("image")!=null)*/
                        reclamation.setDescription(obj.get("description").toString());
                        reclamation.setEmail(obj.get("email").toString());
                        reclamation.setSujet(obj.get("sujet").toString());
                        reclamation.setId_rec((((int)(double) obj.get("idRec"))));
                       Utilisateur u = new Utilisateur();
                        System.out.println( obj.get("idUtilisateur") );
                        Map<String, Object> idUtilisateur = (Map<String, Object>) obj.get("idUtilisateur");
                    int id = (int) (double) idUtilisateur.get("id");
                      u.setId(id);
                      reclamation.setId_utilisateur_id(u);
                  
                        reclamation.setEtat((( obj.get("etat").toString())));
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(reclamation);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        new  ReclamationssearchForm(res,s).show();
    }
     
     
     
     
     
     
     
     
     
     
     
 
       
     /***************************************************************************/
     public void register(Resources res,Reclamation u){
       
                 
  
                    
             
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerReclamation?email="+u.getEmail()+
               "&sujet="+u.getSujet()+
               "&description="+u.getDescription()+
               "&etat="+u.getEtat()+
               "&idUtilisateur="+1;
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
                           
                          
                        
                        
                        currentrec.setId_rec((int)((double) tasks.get("idRec")));
                         
                         
                        
                        
                         
                        }
                        catch(ArrayIndexOutOfBoundsException exs)
                        {
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);
                     
                    status.setMessage("no user found");
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
            new  ReclamationsForm(res).show();
             
         
     }
    
     public void update(Resources res ,Reclamation u){
          
            System.out.println(u.getId_rec());
          
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateReclamationjson?id="+u.getId_rec()+
              "&email="+u.getSujet()+
               "&sujet="+u.getSujet()+
               "&description="+u.getDescription()+
               "&etat="+u.getEtat();
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new ReclamationsForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new ReclamationsForm(res).show();

             
             
            }
    
}
