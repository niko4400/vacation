package application.vacation.web.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.model.User;

@ManagedBean(name = "printPdf")
@SessionScoped
public class PrintPdf implements Serializable {
	



	
	public PrintPdf() {
		// TODO Auto-generated constructor stub
	}


	
	
	public void createPdf() throws IOException{
		FacesContext fC =FacesContext.getCurrentInstance();
		ExternalContext eC =fC.getExternalContext();
		HttpSession session=(HttpSession) eC.getSession(true);
		String url = "http://localhost/:8080/application/navigation/print.xhtml:jsessionid"+session.getId()+"?pdf=true";
		
		try {
			System.out.println("pdf zaczynam");
			ITextRenderer itRenderer=	new ITextRenderer();
			itRenderer.setDocument(new URL(url).toString());
			itRenderer.layout();
			HttpServletResponse response=(HttpServletResponse) eC.getResponse();
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-Dispositon", "inline; filename=\"print-file.pdf\"");
			ServletOutputStream outputStream=response.getOutputStream();
			itRenderer.createPDF(outputStream);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fC.responseComplete();
		
	}

	
	
	
}
