package application.vacation.web.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mock;
import org.xhtmlrenderer.pdf.ITextRenderer;

import application.vacation.web.bean.PrintPdf;

public class PdfTest {

@Mock
PrintPdf pdf=new PrintPdf();
ExternalContext eC;


@Test
	public void test() throws MalformedURLException {
	

		String url2 = "http://localhost:8080/application/navigation/print.xhtml";
		
		URL url=new URL(url2);
		try {
			
			File yourFile = new File("aaa.pdf");
				yourFile.createNewFile();
				FileOutputStream oFile = new FileOutputStream(yourFile, false); 
				
			ITextRenderer itRenderer=	new ITextRenderer();
			itRenderer.setDocument(url.toString());
			itRenderer.layout();
			HttpServletResponse response=(HttpServletResponse) eC.getResponse();
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-Dispositon", "inline; filename=\"print-file.pdf\"");
			ServletOutputStream outputStream=response.getOutputStream();
			
			itRenderer.createPDF(oFile);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
