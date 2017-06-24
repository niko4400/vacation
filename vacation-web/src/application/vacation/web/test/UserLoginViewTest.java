package application.vacation.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.junit.Test;


import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.model.User;
import application.vacation.web.bean.UserCreateView;
import application.vacation.web.bean.UserLoginView;
import application.vacation.web.bean.UserSessionBean;

public class UserLoginViewTest {

@EJB
UserManager userManager;

	@Test
	public void createViewTest(){
		
		UserCreateView createView=new UserCreateView("login","pass","jTitle","1name","2name","mail");
		assertNotNull(createView);
		
	}
	
	@Test
	public void loginViewTest(){
		
		UserLoginView loginView=new UserLoginView(true,true,true, //logged,user,admin
				"login","pass","jTitle","1name","2name","mail");

		assertNotNull(loginView);
		
	}
	
	@Test
	public void testEncrypting(){
		
		UserLoginView loginView=new UserLoginView();
		UserLoginView loginView2=new UserLoginView();

		try {
			loginView.setPassword("password");
			loginView2.setPassword("password");
		} catch (NoSuchAlgorithmException e) {
			fail("no such algorithm");
		}
		
		assertEquals(loginView.getPassword(),loginView2.getPassword());
	}

	
	@Test
	public void testLogInAndOut(){
		
		UserSessionBean userSession=new UserSessionBean();
		
		Boolean defaultSession=false;


		
		UserLoginView loginView=new UserLoginView(true,false,true, //logged,user,admin
			"login","pass","jTitle","1name","2name","mail");
		
		//List<User> users = userManager.findAllUsers();

		User user=new User();
		user.setId(1l);
		user.getPassword();
		userSession.setSession(user);
		loginView.getPassword();

		
		try {
			assertFalse(userSession.checkSession(false)==defaultSession);
		} catch (IOException e) {
			fail("IOException");
		}

		userSession = UserSessionBean.getInstance();
		userSession.destroySession();
		
		//assertEquals(defaultSession,false);

		try {
			assertEquals(defaultSession,userSession.checkSession(false));
		} catch (IOException e) {
			fail("IOException");
		}
	}
	
		
	//	UserCreateView createView=new UserCreateView("login","pass","jTitle","1name","2name","mail");

		//UserLoginView loginView=new UserLoginView(true,false,true, //logged,user,admin
			//	"login","pass","jTitle","1name","2name","mail");


	
}
