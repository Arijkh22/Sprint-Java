/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Publicite;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.PubliciteForm;
import com.mycompany.myapp.PublicitesearchformForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class PubliciteService {
    public static Publicite currentPublicite=new Publicite();
     public ArrayList<Publicite> getAllUsers() {
        ArrayList<Publicite> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/SponsorForm");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> taskss = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(taskss);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) taskss.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Publicite publicite = new Publicite();
                        /*if (obj.get("image")!=null)*/
                        publicite.setNom_pub(obj.get("nomPub").toString());
                        publicite.setDescription(obj.get("description").toString());
                        publicite.setImage(obj.get("image").toString());
                        publicite.setId(((int)(double) obj.get("id")));
                        publicite.setId_sponsor((((int)(double) obj.get("ide"))));
                        
                        
                        
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(publicite);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
     
     
     
     
     
     
     
     
     
      public void getAllpubs(Resources res,String s) {
        ArrayList<Publicite> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/searchedpub?search="+s);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> taskss = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(taskss);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) taskss.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                    for (Map<String, Object> obj : list) {
                        Publicite publicite = new Publicite();
                        /*if (obj.get("image")!=null)*/
                        publicite.setNom_pub(obj.get("nomPub").toString());
                        publicite.setDescription(obj.get("description").toString());
                        publicite.setImage(obj.get("image").toString());
                        publicite.setId(((int)(double) obj.get("id")));
                        publicite.setId_sponsor((((int)(double) obj.get("ide"))));
                        
                        
                        
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(publicite);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       new  PublicitesearchformForm(res,s).show();
    }
    
 
       
     /***************************************************************************/
     public void register(Resources res,Publicite pub){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerPublicite?Description="+pub.getDescription()+
               "&Image="+pub.getImage()+
                "&Nom="+pub.getNom_pub()+
               "&id_sponsor="+pub.getId_sponsor();
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
                           
                          
                        
                        
                        currentPublicite.setId((int)((double) tasks.get("id")));
                         
                         
                        
                        
                         
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
            new  PubliciteForm(res).show();
             
         
     }
    
     public void update(Resources res ,Publicite u){
          
            System.out.println(u.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updatePublicite?id="+u.getId()+
                  "&Description="+u.getDescription()+
               "&Image="+u.getImage()+
               "&Nom="+u.getNom_pub();
              
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new PubliciteForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new PubliciteForm(res).show();

             
             
            }
                  
 
    
    
     }

