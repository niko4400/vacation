package application.vacation.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.User;
import application.vacation.model.Vacation;
import application.vacation.web.bean.UserCreateView;
import application.vacation.web.bean.UserLoginView;
import application.vacation.web.bean.UserSessionBean;

@RunWith(MockitoJUnitRunner.class)
public class CreateLoginVacationTest {


UserCreateView createView= new UserCreateView();
UserLoginView loginView=new UserLoginView();

Vacation vac;
User user;
ActionEvent mockEvent;
List<User> mockList;

@EJB
@Mock
UserManager userManager;
VacationManager vacationManager;


@Mock
UserSessionBean userSession;

	

	@Test
	public void test() {
		user=new User();
		user.setJobTitle("admin");
		
		mockList = userManager.findAllUsers();
		
		userManager.persistUser(user);
		
		loginView.setUser(user);
		try {
			loginView.login(mockEvent,mockList);
		} catch (UserNotFoundException e) {
			fail("user not found");
		}

		if(loginView.getUser().getJobTitle()=="admin")loginView.setLoggedAsAdmin(true);
		
		assertTrue(loginView.getLoggedAsAdmin());
		
		userSession = UserSessionBean.getInstance();
		assertNotNull(userSession);
	}

}
