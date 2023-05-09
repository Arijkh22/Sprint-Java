/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

 
import Entities.Utilisateur;
import Services.UtilisateurService;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;


public abstract class SideMenuBaseForm extends Form {

    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("yy.jpg");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(UtilisateurService.currentUtilisateurc.getNom(), profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        
        getToolbar().addComponentToSideMenu(sidemenuTop);
        Utilisateur u = new Utilisateur();
        getToolbar().addMaterialCommandToSideMenu("  Users", FontImage.MATERIAL_ACCESS_TIME,  e -> new UtilisateursForm(res).show());
            getToolbar().addMaterialCommandToSideMenu("  ADD user", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddUtilisateurForm(res).show());
            
                    getToolbar().addMaterialCommandToSideMenu("  reclamation", FontImage.MATERIAL_ACCESS_TIME,  e -> new ReclamationsForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add reclamation", FontImage.MATERIAL_ACCESS_TIME,  e -> new Addreclamationform(res,u).show());
                    getToolbar().addMaterialCommandToSideMenu("  add reponse", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddRecForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  reponse", FontImage.MATERIAL_ACCESS_TIME,  e -> new ReponceForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  produit", FontImage.MATERIAL_ACCESS_TIME,  e -> new ProduitsForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  categorie", FontImage.MATERIAL_ACCESS_TIME,  e -> new CategoriesForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add produit", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddProduitsForm(res,1).show());
                    getToolbar().addMaterialCommandToSideMenu("  add categorie", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddCategorieForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  liste appel offre", FontImage.MATERIAL_ACCESS_TIME,  e -> new AppelOffreForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  liste reponse offre", FontImage.MATERIAL_ACCESS_TIME,  e -> new ReponseOffreForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add appel offre", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddAppelOffreForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add reponse offre", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddReponseOffreForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  liste sponsor", FontImage.MATERIAL_ACCESS_TIME,  e -> new SponsorForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  liste publicite", FontImage.MATERIAL_ACCESS_TIME,  e -> new PubliciteForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add sponsor", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddSponsorForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  add pub", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddPubliciteForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  finance", FontImage.MATERIAL_ACCESS_TIME,  e -> new FinancesForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu("  facture", FontImage.MATERIAL_ACCESS_TIME,  e -> new FactureForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu(" add facture", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddFactureForm(res).show());
                    getToolbar().addMaterialCommandToSideMenu(" add finance", FontImage.MATERIAL_ACCESS_TIME,  e -> new AddFinanceForm(res).show());
                    


      
        
    }
    
    protected abstract void showOtherForm(Resources res);
}

