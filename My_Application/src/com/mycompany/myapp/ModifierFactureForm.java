/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.FactureService;
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
import Entities.Facture;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author Ahmed
 */
public class ModifierFactureForm extends Form {
        private Resources themes;

    public ModifierFactureForm(Resources theme,Facture b) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        System.out.println(b.getId_facture());
  
      
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;
        nom.setText(b.getNom());
        TextField Prix = new TextField("", "prix", 20, TextField.ANY) ;
        Prix.setText(String.valueOf(b.getPrix()));

        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
        etat.setText( b.getEtat());

        TextField description = new TextField("", "description", 20, TextField.ANY) ;
       description.setText(b.getDescription());
       
       
        nom.getAllStyles().setMargin(LEFT, 0);
        Prix.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        
        
        Label nomIcon = new Label("", "TextField");
        Label PrixIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
       
        
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(PrixIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        Button registerButton = new Button("modifier bac");
        registerButton.setUIID("modifier");
            Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            themes = UIManager.initFirstTheme("/theme");
                     new  FactureForm(themes).show();
                        Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            FactureService service= new FactureService();
            Facture u = new Facture();
            u.setId_facture(b.getId_facture());
            
            
            u.setDescription(description.getText());
            u.setNom(nom.getText());
            u.setEtat(etat.getText());
            
            float prix1 = Float.parseFloat(Prix.getText());
            u.setPrix(prix1);
            
        
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.FactureService aa =new FactureService();

            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(Prix).
                        add(BorderLayout.WEST, PrixIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
               
                registerButton  ,retour              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
