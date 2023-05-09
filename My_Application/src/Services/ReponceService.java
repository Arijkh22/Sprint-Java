/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.ReponseReclamation;
import com.codename1.components.ToastBar;
 
import com.codename1.ui.Dialog;
 
 
 import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.ReponceForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class ReponceService {
    public static ReponseReclamation currentBac=new ReponseReclamation();
     public ArrayList<ReponseReclamation> getAllUsers() {
        ArrayList<ReponseReclamation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/ReponseReclamationlist");
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
                        ReponseReclamation reponseReclamation = new ReponseReclamation();
                        /*if (obj.get("image")!=null)*/
                        reponseReclamation.setDate(obj.get("date").toString());
                        reponseReclamation.setEtat(obj.get("etat").toString());
                        reponseReclamation.setId_reponse(((int)(double) obj.get("idReponse")));
                        reponseReclamation.setSujet((( obj.get("sujet").toString())));
                        reponseReclamation.setId_reclamation((((int)(double) obj.get("idRe"))));
                        
                       
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(reponseReclamation);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
 
       
     /***************************************************************************/
     public void register(Resources res,ReponseReclamation u){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerReponseReclamation?"
               +"sujet="+u.getSujet()+
               "&etat="+u.getEtat()+
               "&id_reclamation="+52;
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
                           
                          
                        
                        
                        currentBac.setId_reponse((int)((double) tasks.get("idReponse")));
                         
                         
                        
                        
                         
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
            new  ReponceForm(res).show();
             
         
     }
    
     public void update(Resources res ,ReponseReclamation u){
          
            System.out.println(u.getId_reponse());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateReponseReclamationjson?id="+u.getId_reponse()+
                  "&sujet="+u.getSujet()+
               "&etat="+u.getEtat();
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new ReponceForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new ReponceForm(res).show();

             
             
            }
                  
 
    
    
     }

