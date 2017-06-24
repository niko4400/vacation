package application.vacation.web.test;

import static org.junit.Assert.*;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import application.vacation.api.exception.UserNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.User;
import application.vacation.model.Vacation;
import application.vacation.web.bean.UserCreateView;
import application.vacation.web.bean.UserLoginView;
import application.vacation.web.bean.UserSessionBean;
import application.vacation.web.bean.VacationView;


@RunWith(MockitoJUnitRunner.class)
public class VacationViewTest {

@EJB
@Mock
UserManager userManager;
@EJB
@Mock
VacationManager vacationManager;

@Mock
ActionEvent mockEvent;// = mock(ActionEvent.class);

	
	@Test
	public void test(){

		VacationView view=new VacationView();
		VacationView defaultView=view;
		List<User>users=userManager.findAllUsers();
		Vacation vacation=new Vacation();
		assertNotNull(vacation);
		
		assertNotNull(users);
		vacationManager.persistVacation(vacation);
		
		//view.create(mockEvent);
		//view.create2(mockEvent,users);
		assertEquals(view,defaultView);
	}
	
	@Test
	public void stringDate(){
		int i=
	}
}