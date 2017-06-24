package application.vacation.web.test;

import static org.junit.Assert.*;

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

import application.vacation.api.manager.UserManager;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.Vacation;
import application.vacation.web.bean.UserCreateView;

@RunWith(MockitoJUnitRunner.class)
public class CreateLoginVacationTest {


UserCreateView createView= new UserCreateView();
@EJB
@Mock
UserManager userManager;

@Mock
Vacation vac;

@Mock
ActionEvent mockEvent;// = mock(ActionEvent.class);


	@Test
	public void test() {
		
	
		createView.userCreate();
	
	}

}
