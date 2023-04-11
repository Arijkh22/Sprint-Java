/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import workshop.entities.Personne;
import workshop.utils.MyDB;

/**
 *
 * @author Andrew
 */
public class ServicePersonne   implements IService<Personne>{
    
    
    Statement Ste;
    Connection con;

    public ServicePersonne() {
        
        con = MyDB.getInstance().getcon();
    }
    
    
    
    
    @Override
    public void AjouterPersonne(Personne t) {
        String req = "INSERT INTO `devappsfinal`.`appel_offre` (`nom`,`quantite`,`budget`,`description`,`date`,`id_utilisateur_id`,`id_categorie_id`) values ('"+t.getNom()+"','"+t.getQuantite()+"','"+t.getBudget()+"','"+t.getDescrition()+"','"+t.getDate()+"','"+t.getIdUtilisateur()+"','"+t.getIdCategorie()+"');";
        try {
            Ste=con.createStatement();
            Ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Err"+ex.getLocalizedMessage());
        }
    }
    
    @Override
    public void AjouterPersonne2(Personne t) {
       
        try {
            PreparedStatement pre = con.prepareStatement("INSERT INTO `devappsfinal`.`appel_offre` (`nom`,`quantite`,`budget`,`description`,`date`,`idUtilisateur`,`idCategorie`) VALUES (?,?,?,?,?,?,?);");
            pre.setString(1, t.getNom());
            pre.setString(2,t.getQuantite());
            pre.setString(3,t.getBudget());
            pre.setString(4,t.getDescrition());
            pre.setString(5, t.getDate());
            
           
            pre.executeUpdate();
                    
            
            
        } catch (SQLException ex) {
            System.out.println("err"+ex.getMessage());
        }
       
    }
    
    @Override
    public void suprrimerPersonne(Personne t) {
        String req = "DELETE FROM `devappsfinal`.`appel_offre` WHERE `id` = ?";
        try {
            PreparedStatement st = con.prepareStatement(req);
            st.setInt(1, t.getId());
            int result = st.executeUpdate();
            if (result > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Suppression réussie");
                alert.setHeaderText(null);
                alert.setContentText("L'offre a été supprimée avec succès!");
                alert.showAndWait();
            }
            else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de supprimer l'offre d'offre.");
            alert.showAndWait();
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Override
    public void modifierPersonne(Personne t) {
        
        String req = "UPDATE `devappsfinal`.`appel_offre` SET `nom` = ?, `quantite` = ?, `budget` = ?, `description` = ? WHERE `id` = ?";
        try (
            PreparedStatement stmt = con.prepareStatement(req)) {
            
            stmt.setString(1, t.getNom());
            stmt.setString(2, t.getQuantite());
            stmt.setString(3, t.getBudget());
            stmt.setString(4, t.getDescrition());
            stmt.setInt(5, t.getId());
            int result = stmt.executeUpdate();
            
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mise à jour réussie");
            alert.setHeaderText(null);
            alert.setContentText("L'appel d'offre a été mis à jour avec succès.");
            alert.showAndWait();
        
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public ArrayList<Personne> afficherpersonne() {
        ArrayList<Personne> pers = new ArrayList<>();
        try {
            Ste= con.createStatement();
       
        String req = "SELECT * FROM `devappsfinal`.`appel_offre`";
            ResultSet res= Ste.executeQuery(req);
            while(res.next()){
                int id = res.getInt(1);
                String nom = res.getString("nom");
                String quantite = res.getString("quantite");
                String budget = res.getString("budget");
                String description = res.getString("description");
                String date = res.getString("date");
                int idUtilisateur = res.getInt(1);
                int idCategorie = res.getInt(1);
                
                Personne p =new Personne(nom, quantite, budget, description, date);
               p.setId(id);
                pers.add(p);
            }
         } catch (SQLException ex) {
             System.out.println("err"+ex.getMessage());
        }
        return pers; 
    }

}
