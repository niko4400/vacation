package application.vacation.web.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.enterprise.context.RequestScoped;


@ManagedBean(name = "navigationBean")
@RequestScoped
public class Vacation implements Serializable {
	
	public static void redirect(String location) {
		//FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, location);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext(); 
		try {
			externalContext.redirect(location);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vacation() {
		// TODO Auto-generated constructor stub
	}
	
	

}
