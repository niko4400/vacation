package application.vacation.web.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.lowagie.text.DocumentException;

@ManagedBean(name = "printPdf")
@SessionScoped
public class PrintPdf implements Serializable {
	



	
	public PrintPdf() {
		// TODO Auto-generated constructor stub
	}


	
	
	public void createPdf() throws DocumentException, IOException {
	
		 String File_To_Convert = "C:/Users/Dominik/git/vacation/vacation-web/WebContent/navigation/print.xhtml";
	        String url = new File(File_To_Convert).toURI().toURL().toString();
	        System.out.println("---"+url);
	        String HTML_TO_PDF = "ConvertedFile.pdf";
	        FileOutputStream os = new FileOutputStream(HTML_TO_PDF);
	     
	         ITextRenderer renderer = new ITextRenderer();
	                renderer.setDocument(url);      
	                renderer.layout();
	                renderer.createPDF(os) ;    
	                os.close();
	          System.out.println("done.");	
	}

	
	
	
}
