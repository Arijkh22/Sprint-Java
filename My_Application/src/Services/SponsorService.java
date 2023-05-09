/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.Sponsor;
import com.codename1.components.ToastBar;
 
import com.codename1.ui.Dialog;
 
 
 import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.SponsorForm;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;



public class SponsorService {
    public static Sponsor currentsponsor=new Sponsor();
     public ArrayList<Sponsor> getAllUsers() {
        ArrayList<Sponsor> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/afficherSponsorjSON");
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
                        Sponsor sponsor = new Sponsor();
                        /*if (obj.get("image")!=null)*/
                        sponsor.setNom(obj.get("nom").toString());
                        sponsor.setAdresse(obj.get("adresse").toString());
                        sponsor.setEmail(obj.get("email").toString());
                        sponsor.setId(((int)(double) obj.get("id")));
                        sponsor.setNum_tel((((int)(double) obj.get("numTel"))));
                  
                     
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(sponsor);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
 
       
     /***************************************************************************/
     public void register(Resources res,Sponsor u){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerSponsor?nom="+u.getNom()+
               "&adresse="+u.getAdresse()+
               "&email="+u.getEmail()+
               "&num_tel="+u.getNum_tel();
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
                           
                          
                        
                        
                        currentsponsor.setId((int)((double) tasks.get("id")));
                         
                         
                        
                        
                         
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
            new  SponsorForm(res).show();
             
         
     }
    
     public void update(Resources res ,Sponsor u){
          
            System.out.println(u.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateSponsor?id="+u.getId()+
                  "&nom="+u.getNom()+
               "&adresse="+u.getAdresse()+
               "&email="+u.getEmail()+
               "&num_tel="+u.getNum_tel();
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new SponsorForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new SponsorForm(res).show();

             
             
            }
                  
 
    
    
     }

