package application.vacation.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.junit.Test;
import org.mockito.Mock;

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
	public void createViewTest() {

		UserCreateView createView = new UserCreateView("login", "pass", "jTitle", "1name", "2name", "mail");
		assertNotNull(createView);

	}

	@Test
	public void loginViewTest() {

		UserLoginView loginView = new UserLoginView(true, true, true, // logged,user,admin
				"login", "pass", "jTitle", "1name", "2name", "mail");

		assertNotNull(loginView);
		assertEquals(loginView.getEmail(), "mail");

	}

	@Test
	public void testEncrypting() {

		UserLoginView loginView = new UserLoginView();
		UserLoginView loginView2 = new UserLoginView();

		try {
			loginView.setPassword("password");
			loginView2.setPassword("password");
		} catch (NoSuchAlgorithmException e) {
			fail("no such algorithm");
		}

		assertEquals(loginView.getPassword(), loginView2.getPassword());
	}

	User user = new User();
	UserSessionBean userSession = new UserSessionBean();
	Map<String, Object> map = new HashMap<String, Object>();

	@Test
	public void testLogInAndOut() {

		assertNotNull(user);
		user.setId(1l);
		user.setPassword("abc");
		assertNotNull(userSession);
		assertNotNull(user);

		user.setFirstName("aaaaaaa");
		userSession.setSession(user, map);
		assertTrue(userSession.getSessionUser(map).equals(user));

	}
}