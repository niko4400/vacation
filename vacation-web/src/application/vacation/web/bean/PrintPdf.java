package application.vacation.web.bean;


import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.inject.Named;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

@ManagedBean("printPdf")
@SessionScoped
public class PrintPdf implements Serializable {
	
	private String printPdf;

	public PrintPdf(){
		
	}
	
	public void createPdf() throws DocumentException, IOException{
		FacesContext fC =FacesContext.getCurrentInstance();
		ExternalContext eC =fC.getExternalContext();
		HttpSession session=(HttpSession) eC.getSession(true);
		String url = "http://localhost/:8080/application/navigation/print.xhtml:jsessionid"+session.getId()+"?pdf=true";
		
		try {
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
