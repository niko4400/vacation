package application.vacation.web.bean;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.lowagie.text.DocumentException;

@ManagedBean(name = "printPdf")
@SessionScoped
public class PrintPdf implements Serializable {
	



	
	public PrintPdf() {
		// TODO Auto-generated constructor stub
	}


	
	
	public void createPdf() throws DocumentException, IOException {
	
		/* String File_To_Convert = "C:/Users/Dawid/git/vacation/vacation-web/WebContent/navigation/vacation.xhtml";
	        String url = new File(File_To_Convert).toURI().toURL().toString();
	        System.out.println("Robie pdf"+url);
	        String HTML_TO_PDF = "Wykazurlopow.pdf";
	        FileOutputStream os = new FileOutputStream(HTML_TO_PDF);
	     
	         ITextRenderer renderer = new ITextRenderer();
	                renderer.setDocument(url);      
	                renderer.layout();
	                renderer.createPDF(os) ;    
	                os.close();
	          System.out.println("done.");	*/
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		HttpSession session = (HttpSession) externalContext.getSession(true);
		
		String url = "http://localhost:8080/vacation-web/navigation/print.xhtml;jsessionid="+session.getId()+"?pdf=true";
		try{
			ITextRenderer renderer = new ITextRenderer();		
			renderer.setDocument(new URL(url).toString());
			renderer.layout();
			HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Vacation schedule", "inline; filename=\"VacationSchedule.pdf\"");	
			ServletOutputStream outputStream = response.getOutputStream();
			renderer.createPDF(outputStream);
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
			facesContext.responseComplete();
	}
	
}
