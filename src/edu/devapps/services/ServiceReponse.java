/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import edu.devapps.entity.Reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import utilites.MaConnexion;


/**
 *
 * @author omaim
 */
public class ServiceReponse implements PService<Reponse>{
    
    
    
    Statement Ste;
    
      com.mysql.jdbc.Connection cnx =utilities.MaConnexion.getInstance().getCnx();


    public ServiceReponse() {
        
    }
    

    @Override
    public void AjouterReponse(Reponse t) {
        
        String req = "INSERT INTO `devappsfinal`.`reponse_offre` (`nom_produit`,`budget`,`Etat`,`date`,`id_offre`) values ('"+t.getNom()+"',"+t.getBudget()+",'"+t.getEtat()+"','"+t.getDate()+"',"+t.getId_offre()+");";
        try {
            Ste=cnx.createStatement();
            Ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Err"+ex.getLocalizedMessage());
        }
    
        
    }

    @Override
    public void AjouterReponse2(Reponse t) {
        
        try {
            PreparedStatement pre = cnx.prepareStatement("INSERT INTO `devappsfinal`.`reponse_offre` (`nom`,`budget`,`Etat`,`date`,`id_offre`) VALUES (?,?,?,?,?);");
            pre.setString(1, t.getNom());
            pre.setString(2,t.getBudget());
            pre.setString(3,t.getEtat());
            pre.setString(4,t.getDate());
            
            pre.executeUpdate();
                    
            
        } catch (SQLException ex) {
            System.out.println("err"+ex.getMessage());
        }
    }

    @Override
    public void suprrimerReponse(Reponse t) {
        String req = "DELETE FROM `devappsfinal`.`reponse_offre` WHERE `id` = ?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, t.getId());
            int result = st.executeUpdate();
            if (result > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Suppression réussie");
                alert.setHeaderText(null);
                alert.setContentText("La reponse a été supprimée avec succès!");
                alert.showAndWait();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Override
    public void modifierReponse(Reponse t) {
        
        String req = "UPDATE `devappsfinal`.`reponse_offre` SET `nom_produit` = ?, `budget` = ?, `Etat` = ?, `date` = ? WHERE `id` = ?";
        try (
            PreparedStatement stmt = cnx.prepareStatement(req)) {
            
            stmt.setString(1, t.getNom());
            stmt.setString(2, t.getBudget());
            stmt.setString(3, t.getEtat());
            stmt.setString(4, t.getDate());
            //stmt.setInt(5, t.getId_offre());
            stmt.setInt(5, t.getId());
            int result = stmt.executeUpdate();
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mise à jour réussie");
            alert.setHeaderText(null);
            alert.setContentText("La reponse d'offre a été mis à jour avec succès.");
            alert.showAndWait();
        
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public ArrayList<Reponse> afficherreponse() {
    
           ArrayList<Reponse> rep = new ArrayList<>();
        try {
            Ste= cnx.createStatement();
       
        String req = "SELECT * FROM `devappsfinal`.`reponse_offre`";
            ResultSet res= Ste.executeQuery(req);
            while(res.next()){
                int id = res.getInt(1);
                String nom = res.getString("nom_produit");
                String budget = res.getString("Budget");
                String Etat = res.getString("Etat");
                String date = res.getString("Date");
                int id_offre = res.getInt(1);
                
                
                Reponse r =new Reponse(nom, budget, Etat, date, id_offre);
                r.setId(id);
                rep.add(r);
            }
         } catch (SQLException ex) {
             System.out.println("err"+ex.getMessage());
        }
        return rep; 
    
    }
    
    
}
