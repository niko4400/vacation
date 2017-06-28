package application.vacation.web.bean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.vacation.model.User;
@Stateless
@ViewScoped
@ManagedBean
public class MailBean {
 
    @Resource(name = "java:jboss/mail/Wp")
    private Session session;
 
    public void send() {
    	User username = null;
    	
		String message1 = " <b>Checkout your manage panel.</b><br>";
        message1 += "<b>Please follow this link to manage: </b><br>";
        message1 += "<font color=blue>http://localhost:8080/vacation-web/navigation/manager.xhtml</font>";
    
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	  facesContext = FacesContext.getCurrentInstance();
    	  username = (User) facesContext.getExternalContext().getSessionMap().get("user");  	  
    	
    	try{
    		    	Properties props = new Properties ();
    		     	props.put("mail.smtp.starttls.enable", "true");
    		     	props.setProperty ("mail.transport.protocol", "smtp");
    		     	props.setProperty ("mail.host", "smtp.wp.pl");
    		     	props.setProperty ("mail.user", "dawidrylo@wp.pl");
    		     	props.setProperty ("mail.password", "gorillaz1"); 
    		     	props.setProperty("mail.smtp.port", "465");
    		     	props.setProperty("mail.smtp.auth", "true");
    		     	props.put("mail.smtp.socketFactory.port", "465");
    		         props.put("mail.smtp.socketFactory.class", 
    		              "javax.net.ssl.SSLSocketFactory");
    		 
    		     	Session mailSession = Session.getDefaultInstance (props,  new javax.mail.Authenticator(){
    		             protected PasswordAuthentication getPasswordAuthentication() {
    		                 return new PasswordAuthentication(
    		                     "dawidrylo@wp.pl", "gorillaz1");
    		             }
    		     });
    		    	mailSession.setDebug (true);
    		     	Transport transport = mailSession.getTransport();
    		 
    		     	MimeMessage message = new MimeMessage (mailSession);
    		     	message.setSubject (username.getFirstName()+" waiting for answer");
    		     	message.setFrom (new InternetAddress ("dawidrylo@wp.pl"));
    		     	message.setContent (message1, "text/html");
    		     	message.addRecipient (Message.RecipientType.TO,
    		    	        new InternetAddress ("dryylo@gmail.com"));
    		 
    		     	transport.connect ();
    		     	transport.sendMessage (message,
    		     	        message.getRecipients (Message.RecipientType.TO));
 
        } catch (MessagingException e) {
            Logger.getLogger(MailBean.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        }
    }
}