/**
 * 
 */
package application.vacation.web.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Singleton;

import application.vacation.model.User;

@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {
	private User user = null;

	/**
	 * 
	 */
	
	 private static UserSessionBean instance = new UserSessionBean();
	
	
	 public Boolean checkSession(Boolean flag) throws IOException {
		 FacesContext facesContext = FacesContext.getCurrentInstance();		 
		 if(facesContext.getExternalContext().getSessionMap().containsKey("user")) {
			 return true;
		 }
		 if(flag) {
			 NavigationBean.redirect("signIn.xhtml");
		 }
		return false;	 
	 }
	 
	 public void setSession(User user) {
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 facesContext = FacesContext.getCurrentInstance();
		 facesContext.getExternalContext().getSessionMap().put("user", user);
		 user = (User) facesContext.getExternalContext().getSessionMap().get("user");
		 System.out.println(user.getFirstName());
	 }
	 public void setSession(User user,Map<String,Object> map) {
		 map.put("user", user);
		 user = (User) map.get("user");
		 System.out.println(user.getFirstName());
	 }
	  
	 // do logout
	 public void destroySession() {
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	 }
	 
	 
	 public static UserSessionBean getInstance(){
		return instance;
	 }
	 
	 
	public UserSessionBean() {

	}

	public User getSessionUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext = FacesContext.getCurrentInstance();
		return (User) facesContext.getExternalContext().getSessionMap().get("user");
	}
	public User getSessionUser(Map<String,Object> map) {

		return (User) map.get("user");
	}

}
