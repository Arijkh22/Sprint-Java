/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entities.Publicite;
import Services.PubliciteService;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jihed Pc
 */
public class PubliciteForm extends SideMenuBaseForm{
    
    public PubliciteForm(Resources res){
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
                                    new Label(PubliciteService.currentPublicite.getNom_pub()+"-"+PubliciteService.currentPublicite.getNom_pub(), "Title"),
                                    new Label(PubliciteService.currentPublicite.getNom_pub(), "SubTitle")
                                )
                            ).add(BorderLayout.WEST, profilePicLabel),
                        GridLayout.encloseIn(2, remainingTasks, completedTasks)
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
                        
        add(new Label("Users list", "TodayTitle"));
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
       
        /*
        parsing tasks
        */
        ArrayList<Publicite> listTasks = new ArrayList<>();
        Publicite pub = new Publicite();
        ConnectionRequest con = new ConnectionRequest();
            TextField d = new TextField("", "Nom", 20, TextField.ANY) ;
        con.setUrl("http://127.0.0.1:8000/afficherP");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData().toCharArray()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    System.out.println(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list.toString());
                    System.out.println("list end here");
                   // Map<String, Object> obj = new HashMap<>();
                     Container box2 = new Container(BoxLayout.y());
                    for (Map<String, Object> obj : list) {
                           Publicite pub = new Publicite();
                                           Container box = new Container(BoxLayout.x());

                        if (obj.get("image")!=null)
                            
                        pub.setNom_pub(obj.get("nomPub").toString());
                          Image edit = res.getImage("edit.png");
                      Image delete = res.getImage("delete.png");
                        
                       delete= delete.fill(1, 1);
                       edit= edit.fill(1, 1);
                       
                        pub.setDescription(obj.get("description").toString());
                     
                        pub.setImage(obj.get("image").toString());
                        pub.setId((int)((double) obj.get("id")));
                        pub.setId_sponsor((int)((double) obj.get("ide")));
                     
                           Label l = new Label(pub.getId()+pub.getNom_pub());
                        box.addComponent(0,l);
                            box.addComponent(1,  editButtonBottom(edit, " "+ "", 0x5ae29d, true,pub,res));
                            box.addComponent(2,  addButtonBottom(edit, " "+ "", 0x5ae29d, true,(int)(double) obj.get("id"),res));

                          box.animateLayout(150);
               
                        
                        
                        
                        
                     box2.add(box);
                        
                        
                        if (obj.get("confirmationToken")!=null)
                      
                        
                        
                        
                        listTasks.add(pub);
                    }
                            
                        
                          add(d);
                    add(box2);
                    d.addActionListener((evtt) -> {
                     PubliciteService ee = new PubliciteService();
                    ee.getAllpubs(res, d.getText());
                    
                    });
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        
        /*
        end parsing tasks
        */
        setupSideMenu(res);
    }
    
    
    private MultiButton addButtonBottom(Image arrowDown, String text, int color, boolean first, int id,Resources rs){
        MultiButton finishLandingPage = new MultiButton(text);
        
         finishLandingPage.addActionListener(e -> {
        
                       Toolbar.setGlobalToolbar(true);
                       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/deletePublicitejson?id="+id+"");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
                           @Override
                           public void actionPerformed(NetworkEvent evt) {
                                
                           new PubliciteForm(rs).show();
                           }
             
         });
        NetworkManager.getInstance().addToQueueAndWait(con);
Form hi = new Form("User profile edit", new BoxLayout(BoxLayout.X_AXIS));
Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);

 Command back = new Command("Publicitek") {
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
        
        
     
            
       private MultiButton editButtonBottom(Image arrowDown, String text, int color, boolean first, Publicite bac,Resources rs){
        MultiButton finishLandingPage = new MultiButton("");
        
         finishLandingPage.addActionListener(e -> {
        
                       Toolbar.setGlobalToolbar(true);
                       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/afficherP");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
                           @Override
                           public void actionPerformed(NetworkEvent evt) {
                               PubliciteService.currentPublicite =bac;
                                System.out.println(bac.getId());
                           new ModifierPubliciteForm(rs,bac).show();
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
