
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
import com.codename1.components.ToastBar;
import com.codename1.ui.plaf.UIManager;


public class AddCategorieForm extends Form {
        private Resources themes;
    public AddCategorieForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        TextField nom = new TextField("", "nom", 20, TextField.ANY) ;      
        nom.getAllStyles().setMargin(LEFT, 0);
        Label nomIcon = new Label("", "TextField");   
        nomIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_CATEGORY, 3);
        Button registerButton = new Button("ajouter categorie");
        registerButton.setUIID("Ajouter categorie");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            CategorieService service= new CategorieService();
            Categorie c = new Categorie();          
            c.setNom(nom.getText());           
               themes = UIManager.initFirstTheme("/theme");
              ToastBar.Status status = ToastBar.getInstance().createStatus();

        if (nom.getText().equals(""))
                      { status.setShowProgressIndicator(true);
                           status.setMessage("nom obligatoire");
                    status.setExpires(2000);
                    status.show(); 
                      }
                      else
     {
         
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        Services.CategorieService aa =new CategorieService();
        System.out.println(aa.getAllCategories());

            service.register(themes, c);
            Toolbar.setGlobalToolbar(true);
     }    });
        
        Container by = BoxLayout.encloseY(
        BorderLayout.center(nom).
        add(BorderLayout.WEST, nomIcon),
               
                registerButton                
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
