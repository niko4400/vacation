package application.vacation.web.servlet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import application.vacation.api.manager.UserManager;
import application.vacation.model.User;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	
	@EJB(beanInterface=UserManager.class)
	private UserManager userManager;
	
	public String userFindAllUsers() {
		//userManager.persistUser(new User());
		//return String.valueOf(userManager.findAllUsers().size());
		return "aadda";
	}
	
	
	public UserBean() {
		
	}

	
	public application.vacation.api.manager.UserManager getUserManager() {
		return userManager;
	}

	
	public void setUserManager(application.vacation.api.manager.UserManager userManager) {
		this.userManager = userManager;
	}


	

	
	
}
