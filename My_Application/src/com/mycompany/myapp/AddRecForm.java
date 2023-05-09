/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ReponceService;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import Entities.ReponseReclamation;
import Services.Mail;



import Services.ReclamationService;
import com.codename1.charts.ChartComponent;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.plaf.UIManager;






public class AddRecForm extends Form {
        private Resources themes;

    public AddRecForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
        
        
                    ReponseReclamation u = new ReponseReclamation();
    
        ComboBox<String> comboBox = new ComboBox<String>();
        ReclamationService s = new ReclamationService();
        for (int i=0;i<s.getAllReclamation().size();i++)
        {
            comboBox.addItem(""+s.getAllReclamation().get(i).getId_rec());
        }
        
        u.setId_reclamation(Integer.parseInt((String) comboBox.getSelectedItem()));
        
  
      
        TextField sujet = new TextField("", "sujet", 20, TextField.ANY) ;
        TextField etat = new TextField("", "etat", 20, TextField.EMAILADDR) ;
        
        
        sujet.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        comboBox.getAllStyles().setMargin(LEFT, 0);
        
        
        Label sujetIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
       
        sujetIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
       
        
        FontImage.setMaterialIcon(sujetIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        comboBox.addActionListener((evt) -> {
        u.setId_reclamation(Integer.parseInt((String)comboBox.getSelectedItem()));
        });
        
        
        Button registerButton = new Button("add reponse");
        registerButton.setUIID("Addrep");
        
         Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            
            themes = UIManager.initFirstTheme("/theme");
             new  ReponceForm(themes).show();
            
             Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ReponceService service= new ReponceService();
            
            u.setEtat(etat.getText());
            u.setSujet(sujet.getText());
            
           
            
              
        
 ToastBar.Status status = ToastBar.getInstance().createStatus();
                   
        if(etat.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                    status.setMessage("etat cant be null");
                    status.setExpires(2000);
                    status.show();
        }
        else if(sujet.getText().equals(""))
        {
             status.setShowProgressIndicator(true);
                     
                    status.setMessage("sujet cant be null");
                    status.setExpires(2000);
                    status.show();
        }
        else 
        {
            
             
        
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ReponceService aa =new ReponceService();
        System.out.println(aa.getAllUsers());

            service.register(themes, u);
            Toolbar.setGlobalToolbar(true);
         }});
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(sujet).
                        add(BorderLayout.WEST, sujetIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                 BorderLayout.center(comboBox),
                registerButton   ,retour             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
