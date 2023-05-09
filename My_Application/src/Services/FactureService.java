/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.Facture;
import com.codename1.components.ToastBar;
 
import com.codename1.ui.Dialog;
 
 
 import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.FactureForm;
import com.mycompany.myapp.FacturesearchForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Ahmed
 */
public class FactureService {
    public static Facture currentBac=new Facture();
     public ArrayList<Facture> getAllUsers() {
        ArrayList<Facture> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/afficherfacturejSONe");
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
                        Facture facture = new Facture();
                        /*if (obj.get("image")!=null)*/
                        facture.setDate(obj.get("date").toString());
                        facture.setDescription(obj.get("description").toString());
                        facture.setEtat( obj.get("etat").toString());
                        facture.setId_facture((((int)(double) obj.get("idFacture"))));
                      //  facture.setId_utilisateur((((int)(double) obj.get("id"))));
                        facture.setImage( obj.get("image").toString());
                        facture.setNom( obj.get("nom").toString());
                        facture.setNumero((((int)(double) obj.get("numero"))));
                        facture.setPrix((((int)(double) obj.get("prix"))));
                        
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(facture);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
 
     
       public void getAllUserssearch(Resources res,String s) {
        ArrayList<Facture> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/searchedjsonfacture?search="+s);
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
                        Facture facture = new Facture();
                        /*if (obj.get("image")!=null)*/
                        facture.setDate(obj.get("date").toString());
                        facture.setDescription(obj.get("description").toString());
                        facture.setEtat( obj.get("etat").toString());
                        facture.setId_facture((((int)(double) obj.get("idFacture"))));
                      //  facture.setId_utilisateur((((int)(double) obj.get("id"))));
                        facture.setImage( obj.get("image").toString());
                        facture.setNom( obj.get("nom").toString());
                        facture.setNumero((((int)(double) obj.get("numero"))));
                        facture.setPrix((((int)(double) obj.get("prix"))));
                        
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(facture);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       new  FacturesearchForm(res,s).show();
    }
       
     /***************************************************************************/
     public void register(Resources res,Facture u){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerFacture?numero="+u.getNumero()+
               "&nom="+u.getNom()+
               "&prix="+u.getPrix()+
               "&etat="+u.getEtat()+
               "&description="+u.getDescription()+
               "&image="+u.getImage()+
                     "&id_Utilisteur="+1 ;     
                        
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
                           
                          
                        
                        
                        currentBac.setId_facture((int)((double) tasks.get("id_facture")));
                         
                         
                        
                        
                         
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
            new  FactureForm(res).show();
             
         
     }
    
     public void update(Resources res ,Facture u){
          
            System.out.println(u.getId_facture());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateFacture?id_facture="+u.getId_facture()+
               "&nom="+u.getNom()+
               "&etat="+u.getEtat()+
               "&prix="+u.getPrix()+
               "&description="+u.getDescription();
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new FactureForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new FactureForm(res).show();

             
             
            }
                  
 
    
    
     }

