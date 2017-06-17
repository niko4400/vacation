package application.vacation.web.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.vacation.api.exception.VacationNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.model.User;


@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Context ctx;
		UserManager userManager = null;
		try {
			ctx = new InitialContext();
			userManager = (UserManager) ctx.lookup("java:app/user-ejb/DefaultCarManager");
		} catch (NamingException e) {
			e.printStackTrace();
		}
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setTitle(title);

		userManager.persistUser(user);
    }
}
