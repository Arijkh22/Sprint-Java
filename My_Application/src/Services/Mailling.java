/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 *
 * @author mega pc
 */


public class Mailling {
    
// from,to,host,sub,content;

public Mailling(){}

public boolean sendemail(String nom)
{
          Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication
   Session session = Session.getInstance(props,null);
try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("manai.amira@esprit.tn"));////
message.setRecipients(
  Message.RecipientType.TO, InternetAddress.parse("manai.amira@esprit.tn"));
message.setSubject("Suppretion d'une matiere");

String msg ="vous avez supprimer la matirere "+nom;

message.setText(msg);

          SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;
            
          
          //badel hthi
         st.connect("smtp.gmail.com",465,"p8490466@gmail.com","cxifeavvuhksltvr");
           
          st.sendMessage(message, message.getAllRecipients());

Transport.send(message);
}catch (MessagingException ex) {
 System.err.println(ex.getMessage());
}
return true;
}



     


}
    
    


     


