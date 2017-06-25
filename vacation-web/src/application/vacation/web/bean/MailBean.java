package application.vacation.web.bean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
 
@Stateless
@ViewScoped
@ManagedBean
public class MailBean {
 
    @Resource(name = "java:jboss/mail/Wp")
    private Session session;
 
    public void send(String addresses, String topic, String textMessage) {
 
    	textMessage="tekst";
    	addresses="dryylo@gmail.com";
    	topic="test";
        try {
        	System.out.println("send start");
            Message message = new MimeMessage(session);
            
            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
            message.setSubject(topic);
            message.setText(textMessage);
 
            Transport.send(message);
            System.out.println("wys³ano");
 
        } catch (MessagingException e) {
            Logger.getLogger(MailBean.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        }
    }
}