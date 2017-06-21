package application.vacation.web.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

@ManagedBean(name = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean loggedIn = false;
	private Boolean loggedAsUser = false;
	private Boolean loggedAsAdmin = false;
	private String login;
	private String password;
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	
	private User user = new User();

	@EJB
	UserManager userManager;
	
	public UserLoginView(){
	}
	
	public UserLoginView(boolean loggedIn,boolean loggedAsUser, boolean loggedAsAdmin,
			String login, String password, String title,
			String firstName, String lastName, String email){
		this.loggedIn=loggedIn;
		this.loggedAsUser=loggedAsUser;
		this.loggedAsAdmin=loggedAsAdmin;
		this.login=login;
		this.password=password;
		this.title=title;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}

	
	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public Boolean getLoggedAsUser() {
		return loggedAsUser;
	}

	public void setLoggedAsUser(Boolean loggedAsUser) {
		this.loggedAsUser = loggedAsUser;
	}

	public Boolean getLoggedAsAdmin() {
		return loggedAsAdmin;
	}

	public void setLoggedAsAdmin(Boolean loggedAsAdmin) {
		this.loggedAsAdmin = loggedAsAdmin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void login(ActionEvent event) throws UserNotFoundException {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		List<User> users = userManager.findAllUsers();

		
		if (login.equals("admin") && password.equals("admin")) {
			
		}

		for (User i : users) {
			if (i.getLogin().equals(login) && i.getPassword().equals(password)) {
				System.out.println("haslo z bazy: "+i.getPassword());
				System.out.println("haslo z formularza " + password);
				if (i.getTitle().equals("admin")) {
					loggedIn = true;
					loggedAsAdmin = true;
					
					UserLoginView userLoginView= new UserLoginView(loggedIn,loggedAsUser,loggedAsAdmin,
							i.getLogin(),password,i.getTitle(),i.getFirstName(),i.getLastName(),i.getEmail());
					facesContext.getExternalContext().getSessionMap().put("user", userLoginView);

					System.out.println("zalogowany");
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel administracyjny", "Sekretarka");
					break;
				}
				loggedIn = true;
				loggedAsUser = true;
				

				UserLoginView userLoginView= new UserLoginView(loggedIn,loggedAsUser,loggedAsAdmin,
						i.getLogin(),password,i.getTitle(),i.getFirstName(),i.getLastName(),i.getEmail());
				facesContext.getExternalContext().getSessionMap().put("user", userLoginView);
				
				//System.out.println("zalogowany");
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Witamy: ", login);
				break;
			}
		}

		if (loggedIn == false) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nie zalogowano", "Wprowadzono błędne dane");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}
	
	public void logout(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
