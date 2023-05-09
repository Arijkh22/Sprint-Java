/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.ReponseOffre;
import com.codename1.components.ToastBar;
 
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.ReponseOffreForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class ReponseOffreService {
    public static ReponseOffre currentBac=new ReponseOffre();
    
     public void register(Resources res,ReponseOffre reps){
       
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerreponseOffre?nom_produit="+reps.getNom_produit()+
               "&budget="+reps.getBudget()+
               "&Etat="+reps.getEtat()+
               "&id_offre="+reps.getIdOffre();
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
                           
                        currentBac.setId((int)((double) tasks.get("id")));
                         
                        }
                        catch(ArrayIndexOutOfBoundsException exs)
                        {
                            ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);
                     
                    status.setMessage("no reponse found");
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
            new  ReponseOffreForm(res).show();
             
         
     }
    
     public void update(Resources res ,ReponseOffre rep){
          
            System.out.println(rep.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateReponseJson?id="+rep.getId()+
                  "&nom_produit="+rep.getNom_produit()+
                  "&budget="+rep.getBudget()+
               "&Etat="+rep.getEtat();
               
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new ReponseOffreForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new ReponseOffreForm(res).show();

            } 
     }

