package application.vacation.web.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.model.User;

@ManagedBean(name = "userCreateView")
@SessionScoped
public class UserCreateView implements Serializable {
	
	private String login;
	private String password;
	private String jobTitle;
	private String name;
	private String email;
	private String firstName;
	private String lastName;
	
	
	@EJB
	UserManager userManager;
	
	User user = new User();
	
	public User getUser(){
		return this.user;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
   
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
	
	
	public void setPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(password.getBytes());
		byte[] digest = messageDigest.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		password = bigInt.toString(16);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public UserCreateView(String login, String password, String jobTitle,
			String firstName, String lastName, String email){
		this.login=login;
		this.password=password;
		this.jobTitle=jobTitle;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
		
	
	public int userCreate() {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage message = null;

		List<User> users = userManager.findAllUsers();

		for (User i : users) {
			if (i.getLogin().equals(login) ) {	
				//TODO login juz istnieje 
				return -1;
			}
		}

		user.setLogin(login);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setJobTitle(jobTitle);
		
		System.out.println("login " + user.getLogin());
		System.out.println("password " + user.getPassword());
		System.out.println("title " + user.getJobTitle());
		
		userManager.persistUser(user);
		
		NavigationBean.redirect("index.xhtml");
		
		return 0;
	}
	
	
	public UserCreateView() {
		// TODO Auto-generated constructor stub
	}

}
