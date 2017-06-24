package application.vacation.web.test;

import static org.junit.Assert.*;

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

@RunWith(MockitoJUnitRunner.class)
public class UserCreateViewTest {

@Mock
UserCreateView createView= new UserCreateView();
@EJB
@Mock
UserManager userManager;
User user;
List<User> mockList;



	@Test
	public void test() {
		mockList=userManager.findAllUsers();
		List<User>users=userManager.findAllUsers();

		/*UserCreateView createView2= new UserCreateView();
		createView2.setEmail("aaa");
		createView2.userCreate(mockList);
		assertEquals(createView2.getEmail(),"aaa");
		*/
		
		
		userManager.persistUser(user);
		userManager.removeUser(user);
		try {
			assertFalse(userManager.findUserToLogin(user).contains(user));
		} catch (UserNotFoundException e) {
			fail("user not found");
		}
	}
}