
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
import Services.CategorieService;
import Services.Mail;
import com.codename1.components.ToastBar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.UIManager;



public class AddProduitsForm extends Form {
        private Resources themes;

    public AddProduitsForm(Resources theme, int id) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        CategorieService ddd = new CategorieService();
               Produit p = new Produit();
      ComboBox<String> comboBox = new ComboBox<String>();
      
      for (int  i=0;i<ddd.getAllCategories().size();i++ )
      {
           comboBox.addItem(""+ddd.getAllCategories().get(i).getId());
      }
      p.setId_categorie(Integer.parseInt((String) comboBox.getSelectedItem()));
      
      
      
        TextField nomProduit = new TextField("", "nomProduit", 20, TextField.ANY) ;
        TextField description = new TextField("", "description", 20, TextField.ANY) ;
        TextField prix = new TextField("0", "prix", 20, TextField.ANY) ;
        TextField quantite = new TextField("0", "quantite", 20, TextField.ANY) ;
        TextField photo = new TextField("", "photo", 20, TextField.ANY) ;
        
        nomProduit.getAllStyles().setMargin(LEFT, 0);
        description.getAllStyles().setMargin(LEFT, 0);
        prix.getAllStyles().setMargin(LEFT, 0);
        quantite.getAllStyles().setMargin(LEFT, 0);
        photo.getAllStyles().setMargin(LEFT, 0);
        comboBox.getAllStyles().setMargin(LEFT, 0);
        
        
        Label nomProduitIcon = new Label("", "TextField");
        Label descriptionIcon = new Label("", "TextField");
        Label prixIcon = new Label("", "TextField");
        Label quantiteIcon = new Label("", "TextField");
        Label photoIcon = new Label("", "TextField");
        
        nomProduitIcon.getAllStyles().setMargin(RIGHT, 0);
        descriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        prixIcon.getAllStyles().setMargin(RIGHT, 0);
        quantiteIcon.getAllStyles().setMargin(RIGHT, 0);
        photoIcon.getAllStyles().setMargin(RIGHT, 0);
        
        FontImage.setMaterialIcon(prixIcon, FontImage.MATERIAL_PRICE_CHECK, 3);
        FontImage.setMaterialIcon(quantiteIcon, FontImage.MATERIAL_SHOPPING_BASKET, 3);
        FontImage.setMaterialIcon(photoIcon, FontImage.MATERIAL_ADD_A_PHOTO, 3);
        FontImage.setMaterialIcon(nomProduitIcon, FontImage.MATERIAL_DRIVE_FILE_RENAME_OUTLINE, 3);
        FontImage.setMaterialIcon(descriptionIcon, FontImage.MATERIAL_DESCRIPTION, 3);

        comboBox.addActionListener((evt) -> {
            String d = (String) comboBox.getSelectedItem();
            System.out.println(d);
            int a= Integer.parseInt((String) comboBox.getSelectedItem());
            p.setId_categorie(a);
        });
        Button registerButton = new Button("ajouter produit");
        registerButton.setUIID("Ajouter Produit");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            ProduitService service= new ProduitService();
     
            
            p.setNom(nomProduit.getText());
            p.setDescription(description.getText());
            
            int quantite1 = Integer.parseInt(quantite.getText());
            p.setQuantite(quantite1);
            
            p.setPhoto(photo.getText());

            float prix1 = Float.parseFloat(prix.getText());
            p.setPrix(prix1);
         ToastBar.Status status = ToastBar.getInstance().createStatus();
               
           
                      if (prix1<1)
                      {
                               status.setShowProgressIndicator(true);
                     
                    status.setMessage("le prix ne peut pas etre 0");
                    status.setExpires(2000);
                    status.show();
                      }
                      else if (photo.getText().equals(""))
                      { status.setShowProgressIndicator(true);
                           status.setMessage("la photo ne peut pas etre vide");
                    status.setExpires(2000);
                    status.show(); 
                      }
                      else if (nomProduit.getText().equals(""))
                      { status.setShowProgressIndicator(true);
                               status.setMessage("le nom ne peut pas etre 0");
                    status.setExpires(2000);
                    status.show(); 
                          
                      }else if (quantite1<10)
                      { status.setShowProgressIndicator(true);
                             status.setMessage("la quantite doit etre supérieur à 10");
                    status.setExpires(2000);
                    status.show(); 
                      }
                      else if (description.getText().equals(""))
                      { status.setShowProgressIndicator(true);
                            status.setMessage("description ne peut pas etre 0");
                    status.setExpires(2000);
                    status.show(); 
                          
                      }
                       else if (nomProduit.getText().equals(""))
                      { status.setShowProgressIndicator(true);
                              status.setMessage("nomProduit ne peut pas etre 0");
                    status.setExpires(2000);
                    status.show();   
                      }
                      else
                       {
                           
                try {
                    Mail.sendMail("arij.khedhira@esprit.tn", 0);
                } catch (Exception ex) {
                  
                }
       
               themes = UIManager.initFirstTheme("/theme");

        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.ProduitService aa =new ProduitService();
        System.out.println(aa.getAllProducts());

            service.register(themes, p);
            Toolbar.setGlobalToolbar(true);
      }  });
        
       
       
        
  
     
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nomProduit).
                        add(BorderLayout.WEST, nomProduitIcon),
                BorderLayout.center(description).
                        add(BorderLayout.WEST, descriptionIcon),
                BorderLayout.center(prix).
                        add(BorderLayout.WEST, prixIcon),
                BorderLayout.center(quantite).
                        add(BorderLayout.WEST, quantiteIcon),
                   BorderLayout.center(photo).
                        add(BorderLayout.WEST, photoIcon),
                   BorderLayout.center(comboBox),
                registerButton                
        );
        add(BorderLayout.CENTER, by);
        
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
