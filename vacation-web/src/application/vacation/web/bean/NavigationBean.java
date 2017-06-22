package application.vacation.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.enterprise.context.RequestScoped;


@ManagedBean(name = "navigationBean")
@RequestScoped
public class NavigationBean implements Serializable {
	
	public static void redirect(String location) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, location);
	}

	public NavigationBean() {
		// TODO Auto-generated constructor stub
	}
	
	

}
