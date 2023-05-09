
package com.mycompany.myapp;

import Services.CategorieService;
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
import Entities.Categorie;
import com.codename1.ui.plaf.UIManager;


public class ModifierCategorieForm extends Form {
        private Resources themes;

    public ModifierCategorieForm(Resources theme,Categorie c) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        System.out.println(c.getId());
  
      
        TextField nom = new TextField("", "nomcategorie", 20, TextField.ANY) ;
        nom.setText(c.getNom());
        
        nom.getAllStyles().setMargin(LEFT, 0); 
        
        Label nomIcon = new Label("", "TextField");
        
        nomIcon.getAllStyles().setMargin(RIGHT, 0);
        
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_CATEGORY, 3);
     
        
        Button registerButton = new Button("modifier categorie");
        registerButton.setUIID("modifier");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            CategorieService service= new CategorieService();
            Categorie cat = new Categorie();
            cat.setId(c.getId());
            cat.setNom(nom.getText());
            
               themes = UIManager.initFirstTheme("/theme");

        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.CategorieService aa =new CategorieService();

            aa.update(themes,cat);
            Toolbar.setGlobalToolbar(true);
        });
        
        
        Container by = BoxLayout.encloseY(

                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
             
                registerButton                
        );
        add(BorderLayout.CENTER, by);
        
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
