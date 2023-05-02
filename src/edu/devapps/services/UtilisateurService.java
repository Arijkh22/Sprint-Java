/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utilities.MaConnexion;

/**
 *
 * @author THEOLDISBACK
 */
public class UtilisateurService {
    
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterutilisateur(Utilisateur r) {
        String req ="INSERT INTO `utilisateur`( `nom`, `prenom`, `password`,  `email`,  `adresse`,  `role`,  `age`,  `username`,  `photo`) VALUES"+ " ('"+r.getNom()+"','"+r.getPrenom()+"','"+r.getPassword()+"','"+r.getEmail()+"','"+r.getAdresse()+"','"+r.getRole()+"','"+r.getAge()+"','"+r.getUsername()+"','"+r.getPhoto()+"'"+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("utilisateur ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Utilisateur> afficherutilisateur() {
        //var
        
       
        List<Utilisateur> utilisateurs =new ArrayList<>();
        //requette
        String req ="SELECT * FROM utilisateur";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),rs.getInt(11),rs.getInt(12)));
              }
          } catch (SQLException ex) {
              }
    
        return utilisateurs;

    
       
    }
    

    public void supprimerUtilisateur( Utilisateur r  ) {
 String req="DELETE FROM `utilisateur` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("utilisateur supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
public void modifierutilisateur( Utilisateur r ) {

    String req=null;
    if(r.getId()!=0)
    {   

        req="UPDATE `utilisateur` SET nom='"+r.getNom()+"',prenom='"+r.getPrenom()+"',email='"+r.getEmail()+"',adresse='"+r.getAdresse()+"',username='"+r.getUsername()+"' where id ="+r.getId();

        try {
         //insert
         Statement st=cnx.createStatement();
         st.executeUpdate(req);
         System.out.println("utilisateur modifier avec succes");
     } catch (SQLException ex) {
         ex.printStackTrace();
     }

    }
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
           
            
               public int generer(int ID_UTILISATEUR) throws SQLException{
        Random rand = new Random();
        int code = rand.nextInt((9999 - 1000) + 1) + 1000;
        
        String req="UPDATE `utilisateur` SET `code`= ? WHERE id=?";
            
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,code);
            pst.setInt(2,ID_UTILISATEUR);            
            pst.executeUpdate();
        return code;
    }
    public  List<Utilisateur>  login (String username,String password) throws SQLException
    {
      List<Utilisateur> users= new ArrayList<>();
        Utilisateur c= new Utilisateur();
        String req="SELECT * FROM utilisateur WHERE  username='"+username+"' and password='"+password+"'"; 
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            Utilisateur u = new Utilisateur();
            u.setId(RS.getInt(1));
            u.setNom(RS.getString(2));
             u.setPrenom(u.decrypt(RS.getString(3)))   ;
             u.setPassword(RS.getString(4));
            u.setEmail(RS.getString(5));
            u.setAdresse(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setAge(RS.getDate(8));
             u.setUsername(RS.getString(9));
            u.setPhoto(RS.getString(10));
            
            u.setBloquer(RS.getInt(11));
            u.setCode(RS.getInt(12));
       // 
       users.add(u);
            
        }
        if (users.size()==0)
            System.out.println("username or password incorrect");
        return users;
        
    }
    
    
      public  List<Utilisateur>  serchwithmail (String mail) throws SQLException
    {
      List<Utilisateur> users= new ArrayList<>();
        Utilisateur c= new Utilisateur();
        String req="SELECT id FROM utilisateur WHERE   email='"+mail+"';"; 
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            Utilisateur u = new Utilisateur();
            u.setId(RS.getInt(1));
           
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        if (users.size()==0)
            System.out.println("username or password incorrect");
        return users;
        
    }
    
      
      
    public List<Utilisateur>  resetpassword (String code,int id) throws SQLException
    {
              List<Utilisateur> users= new ArrayList<>();

        String req="SELECT * FROM utilisateur WHERE code="+code+" AND id="+id;
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
          while (RS.next()){
            
           
              Utilisateur u = new Utilisateur();
        
            u.setId(RS.getInt(1));
            u.setNom(RS.getString(2));
             u.setPrenom(u.decrypt(RS.getString(3)))   ;
             u.setPassword(RS.getString(4));
            u.setEmail(RS.getString(5));
            u.setAdresse(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setAge(RS.getDate(8));
             u.setUsername(RS.getString(9));
            u.setPhoto(RS.getString(10));
            
            u.setBloquer(RS.getInt(11));
            u.setCode(RS.getInt(12));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
          if(users.size()==0)
          {
              System.out.println("code incorrect");
          }
    
       return  users;
    }
    public void enternewpassword (String password, int id) throws SQLException
    {
          
        String req="UPDATE `utilisateur` SET `password`='"+password+"' WHERE id="+id+";";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("mot de passe a changer");
    }
    
    
    
    
    
    
    
    
    
     public List<Utilisateur> rechercher(String s) {
        //var
        
       
        List<Utilisateur> utilisateurs =new ArrayList<>();
        //requette
        String req ="SELECT * FROM utilisateur  where id like '%"+s+"%' OR nom like  '%"+s+"%' OR prenom like '%"+s+"%' OR  email like '%"+s+"%' OR adresse like '%"+s+"%' OR username like '%"+s+"%'";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),rs.getInt(11),rs.getInt(12)));
              }
          } catch (SQLException ex) {
              }
    
        return utilisateurs;

    
       
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
      
public void banuser( Utilisateur r,int i ) {

    String req=null;
    if(r.getId()!=0)
    {   

        req="UPDATE `utilisateur` SET bloquer="+i+"  where id ="+r.getId();

        try {
         //insert
         Statement st=cnx.createStatement();
         st.executeUpdate(req);
         System.out.println("utilisateur modifier avec succes");
     } catch (SQLException ex) {
         ex.printStackTrace();
     }

    }
       
}
    
}


