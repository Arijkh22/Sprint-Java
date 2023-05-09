/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.FinanceServices;
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
import Entities.Finance;
import Entities.Finance;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author Ahmed
 */
public class ModifierFinanceForm extends Form {
        private Resources themes;

    public ModifierFinanceForm(Resources theme,Finance b,int id) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
         System.out.println(b.getId());
  
      
        TextField tva = new TextField("", "tva", 20, TextField.ANY) ;
        tva.setText(""+b.getTva());
        TextField taxe = new TextField("", "taxe", 20, TextField.EMAILADDR) ;
        taxe.setText(""+b.getTaxe());

        TextField prix = new TextField("", "prix", 20, TextField.ANY) ;
        prix.setText( ""+b.getPrix());

        TextField etat = new TextField("", "etat", 20, TextField.ANY) ;
       etat.setText(String.valueOf(b.getEtat()));

       
        tva.getAllStyles().setMargin(LEFT, 0);
        prix.getAllStyles().setMargin(LEFT, 0);
        etat.getAllStyles().setMargin(LEFT, 0);
        taxe.getAllStyles().setMargin(LEFT, 0);
     
        
        Label tvaIcon = new Label("", "TextField");
        Label prixIcon = new Label("", "TextField");
        Label etatIcon = new Label("", "TextField");
        Label taxeIcon = new Label("", "TextField");
        
        tvaIcon.getAllStyles().setMargin(RIGHT, 0);
        prixIcon.getAllStyles().setMargin(RIGHT, 0);
        etatIcon.getAllStyles().setMargin(RIGHT, 0);
        taxeIcon.getAllStyles().setMargin(RIGHT, 0);
        
        
        FontImage.setMaterialIcon(tvaIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(prixIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(etatIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(taxeIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        
        
        Button registerButton = new Button("modifier finance");
        registerButton.setUIID("modifier");
        
            Button retour = new Button("retour");
        retour.setUIID("retour");
        retour.addActionListener((evtt) -> {
        
            themes = UIManager.initFirstTheme("/theme");
                     new  FinancesForm(themes).show();
                        Toolbar.setGlobalToolbar(true);
        });
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            FinanceServices service= new FinanceServices();
            Finance u = new Finance();
           
            
            u.setId(b.getId());
            u.setEtat(etat.getText());
           u.setId_facture(b.getId_facture());
            
            int  tvaa = Integer.parseInt(tva.getText());
            u.setTva(tvaa);
            
             float taxee = Float.parseFloat(taxe.getText());
            u.setTaxe(taxee);
             float prixe = Float.parseFloat(prix.getText());
            u.setTaxe(prixe);
                       
               themes = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.FinanceServices aa =new FinanceServices();
            u.setId(id);
            aa.update(themes, u);
            Toolbar.setGlobalToolbar(true);
        });
        
       
       
        
  
        // We remove the extra space for low resolution devices so things fit better
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(tva).
                        add(BorderLayout.WEST, tvaIcon),
                BorderLayout.center(taxe).
                        add(BorderLayout.WEST, taxeIcon),
                BorderLayout.center(prix).
                        add(BorderLayout.WEST, prixIcon),
                BorderLayout.center(etat).
                        add(BorderLayout.WEST, etatIcon),
                  
                registerButton   , retour             
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
  
    }
}
