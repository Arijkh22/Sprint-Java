/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

 
import Entities.Finance;
import com.codename1.components.ToastBar;
 
import com.codename1.ui.Dialog;
 
 
 import com.codename1.ui.util.Resources;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.FinancesForm;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Ammar
 */
public class FinanceServices {
    public static Finance currentFinance=new Finance();
     public ArrayList<Finance> getAllUsers() {
        ArrayList<Finance> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/afficherfinancejSON");
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
                        Finance finance = new Finance();
                        /*if (obj.get("image")!=null)*/
                        finance.setTaxe( ((float)(double) obj.get("taxe")));
                        finance.setTva( ((int)(double) obj.get("tva")));
                        finance.setPhoto(obj.get("photo").toString());
                        finance.setPrix( ((float)(double) obj.get("prix")));
                        finance.setEtat(obj.get("etat").toString());
                        finance.setDate(obj.get("date").toString());
                        finance.setId_facture(((int)(double) obj.get("ide")));
                        
                        finance.setId((( (int)(double)obj.get("id"))));
                     //   user.setId((int)((double) obj.get("id")));
                     //   user.setRole(obj.get("role").toString());
                       
                        
                        /*if (obj.get("confirmationToken")!=null)*/
                      
                        
                        
                        
                        listTasks.add(finance);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
    
 
       
     /***************************************************************************/
     public void register(Resources res,Finance u){
       
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/registerFinance?"+
               "taxe="+u.getTaxe()+
               "&tva="+u.getTva()+
               "&photo="+u.getPhoto()+
               "&prix="+u.getPrix()+
               "&etat="+u.getEtat()+
               "&id_facture="+u.getId_facture();
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
                           
                          
                        
                        
                        currentFinance.setId((int)((double) tasks.get("id")));
                         
                         
                        
                        
                         
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
            new  FinancesForm(res).show();
             
         
     }
    
     public void update(Resources res ,Finance u){
          
            System.out.println(u.getId());
                 
                ConnectionRequest r = new ConnectionRequest();
                 String url =  "http://127.0.0.1:8000/updateFinance?id="+u.getId()+
               "&taxe="+u.getTaxe()+
                "&tva="+u.getTva()+
               "&prix="+u.getPrix()+
               "&etat="+u.getEtat()+
               "&id_facture="+u.getId_facture();
            r.setUrl(url);
           
            
            r.setPost(true);
             r.addArgument("encoding", "json");
            r.setContentType("application/json");
            NetworkManager.getInstance().addToQueueAndWait(r);
            r.addResponseListener(resp -> {
           new FinancesForm(res).show();
            });
            ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setShowProgressIndicator(true);
            status.setMessage("progress.... ");
            status.show();
         new FinancesForm(res).show();

             
             
            }
                  
 
    
    
     }

