
package com.mycompany.myapp;

import Entities.Produit;
import Services.ProduitService;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 


public class ProduitsForm extends SideMenuBaseForm{
    
    public ProduitsForm(Resources res){
            super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("yy.jpg");
        Image mask = res.getImage("round-mask.png");
        Image masklist = res.getImage("unselected-walkthru.png");
        Image edit = res.getImage("edit.jpg");
        Image delete = res.getImage("delete.png");
        Label editlabel = new Label(edit, "editlabel");
        Label deletelabel = new Label(delete, "editlabel");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());
TextField d = new TextField("", "chercher produit", 20, TextField.ANY) ;      
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        Container remainingTasks = BoxLayout.encloseY(
                        new Label("12", "CenterTitle"),
                        new Label("remaining tasks", "CenterSubTitle")
                );
        remainingTasks.setUIID("RemainingTasks");
        Container completedTasks = BoxLayout.encloseY(
                        new Label("32", "CenterTitle"),
                        new Label("completed tasks", "CenterSubTitle")
        );
        completedTasks.setUIID("CompletedTasks");

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label(ProduitService.currentProduit.getNom()+"-"+ProduitService.currentProduit.getNom(), "Title"),
                                    new Label(ProduitService.currentProduit.getNom(), "SubTitle")
                                )
                            ).add(BorderLayout.WEST, profilePicLabel),
                        GridLayout.encloseIn(2, remainingTasks, completedTasks)
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
                        
        add(new Label("Liste des produits", "TodayTitle"));
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        ArrayList<Produit> listTasks = new ArrayList<>();
        Produit produit = new Produit();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Produitlistjson");
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
                   // Map<String, Object> obj = new HashMap<>();
                     Container box2 = new Container(BoxLayout.y());
                    for (Map<String, Object> obj : list) {
                                           Container box = new Container(BoxLayout.x());
        Produit produit = new Produit();
                        if (obj.get("image")!=null)
                            
                       produit.setNom(obj.get("ref").toString());
                          Image edit = res.getImage("edit.png");
                      Image delete = res.getImage("delete.png");
                        
                       delete= delete.fill(1, 1);
                       edit= edit.fill(1, 1);
              
                        produit.setDescription(obj.get("description").toString());
                        produit.setNom(obj.get("nomProduit").toString());
                        produit.setPrix( ((int)(double) obj.get("prix")));
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setQuantite( ((int)(double) obj.get("quantite")));
                        produit.setId_produit( ((int)(double) obj.get("idProduit")));
                        produit.setId_categorie( ((int)(double) obj.get("ide")));
                           Label l = new Label(produit.getId_produit()+produit.getNom());
                        box.addComponent(0,l);
                        box.addComponent(1,  editButtonBottom(edit, " "+ "", 0x5ae29d, true,produit,res));
                        box.addComponent(2,  addButtonBottom(edit, " "+ "", 0x5ae29d, true,(int)(double) obj.get("idProduit"),res));
                        box.animateLayout(150); 
                     box2.add(box);
                                   
                        if (obj.get("confirmationToken")!=null)
                        listTasks.add(produit);
                    }
                    add(d);
                    add(box2);
                    d.addActionListener((evtt) -> {
                        ProduitService s = new ProduitService();
                           s.getAllProductssearch(res, d.getText());
                    });
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        setupSideMenu(res);
    }
    
    
    private MultiButton addButtonBottom(Image arrowDown, String text, int color, boolean first, int id,Resources rs){
        MultiButton finishLandingPage = new MultiButton(text);
        
         finishLandingPage.addActionListener(e -> {
        
                       Toolbar.setGlobalToolbar(true);
                       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/deleteProduitt?id="+id+"");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
                           @Override
                           public void actionPerformed(NetworkEvent evt) {
                                
                           new ProduitsForm(rs).show();
                           }
             
         });
        NetworkManager.getInstance().addToQueueAndWait(con);
Form hi = new Form("User profile edit", new BoxLayout(BoxLayout.X_AXIS));
Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);

 Command back = new Command("Back") {
    @Override
    public void actionPerformed(ActionEvent evt) {
        showBack();
    }
};
 hi.getToolbar().setBackCommand(back);
 
  
         }
        ); 
                               Image delete = rs.getImage("delete.png");
delete= delete.fill(80, 80);
        finishLandingPage.setEmblem(delete);
                finishLandingPage.setEmblem(delete);

        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIconUIID("Container");
        return finishLandingPage;
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    
    }
        
        
     
            
       private MultiButton editButtonBottom(Image arrowDown, String text, int color, boolean first, Produit produit,Resources rs){
        MultiButton finishLandingPage = new MultiButton("");
        
         finishLandingPage.addActionListener(e -> {
        
                       Toolbar.setGlobalToolbar(true);
                       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Produitlistjson");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
                           @Override
                           public void actionPerformed(NetworkEvent evt) {
                               ProduitService.currentProduit =produit;
                                System.out.println(produit.getId_produit());
                           new ModifierProduitsForm(rs,produit).show();
                           }
             
         });
        NetworkManager.getInstance().addToQueueAndWait(con);
Form hi = new Form("User profile edit", new BoxLayout(BoxLayout.X_AXIS));
Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);

 Command back = new Command("Back") {
    @Override
    public void actionPerformed(ActionEvent evt) {
        showBack();
    }
};
 hi.getToolbar().setBackCommand(back);
 
  
         }
        ); 
                               Image edit = rs.getImage("edit.png");
edit= edit.fill(80, 80);
        finishLandingPage.setEmblem(edit);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIconUIID("Container");
  return finishLandingPage;
    } 
    

    @Override
    protected void showOtherForm(Resources res) {
    }
}
