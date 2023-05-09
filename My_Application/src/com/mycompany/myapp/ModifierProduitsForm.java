
package com.mycompany.myapp;

import Services.ProduitService;
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
import Entities.Produit;
import com.codename1.ui.plaf.UIManager;


public class ModifierProduitsForm extends Form {
        private Resources themes;

    public ModifierProduitsForm(Resources theme,Produit b) {
           super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        System.out.println(b.getId_produit());
  
      
        TextField nomProduit = new TextField("", "nomProduit", 20, TextField.ANY) ;
        nomProduit.setText(b.getNom());
        
        TextField description = new TextField("", "description", 20, TextField.ANY) ;
        description.setText(b.getDescription());

        TextField prix = new TextField("", "prix", 20, TextField.ANY) ;
        prix.setText( String.valueOf(b.getPrix()));

        TextField quantite = new TextField("", "quantite", 20, TextField.ANY) ;
       quantite.setText(String.valueOf(b.getQuantite()));


        nomProduit.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        prix.getAllStyles().setMargin(LEFT, 0);
        quantite.getAllStyles().setMargin(LEFT, 0);
        
        Label nomProduitIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        Label prixIcon = new Label("", "TextField");
        Label quantiteIcon = new Label("", "TextField");
        
        nomProduitIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        quantiteIcon.getAllStyles().setMargin(RIGHT, 0);
        prixIcon.getAllStyles().setMargin(RIGHT, 0);
        
        FontImage.setMaterialIcon(prixIcon, FontImage.MATERIAL_PRICE_CHECK, 3);
        FontImage.setMaterialIcon(quantiteIcon, FontImage.MATERIAL_SHOPPING_BASKET, 3);
        FontImage.setMaterialIcon(nomProduitIcon, FontImage.MATERIAL_DRIVE_FILE_RENAME_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_DESCRIPTION, 3);
        
        Button registerButton = new Button("modifier produit");
        registerButton.setUIID("modifier");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ProduitService service= new ProduitService();
            
            Entities.Produit p = new Produit();
            
            p.setNom(nomProduit.getText());
            p.setDescription(description.getText());
            p.setId_produit(b.getId_produit());
            float prix1 = Float.parseFloat(prix.getText());
            p.setPrix(prix1);
            
            int quantite1 = Integer.parseInt(quantite.getText());
            p.setQuantite(quantite1);
            
                        
               themes = UIManager.initFirstTheme("/theme");

        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ProduitService aa =new ProduitService();

            aa.update(themes, p);
            Toolbar.setGlobalToolbar(true);
        });
        
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nomProduit).
                        add(BorderLayout.WEST, nomProduitIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
                BorderLayout.center(prix).
                        add(BorderLayout.WEST, prixIcon),
                BorderLayout.center(quantite).
                        add(BorderLayout.WEST, quantiteIcon),
                 
                registerButton                
        );
        add(BorderLayout.CENTER, by);
        
        by.setScrollableY(true);
        by.setScrollVisible(false);
    
    }
}
