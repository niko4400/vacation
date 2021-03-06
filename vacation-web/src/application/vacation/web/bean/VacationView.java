package application.vacation.web.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import application.vacation.api.manager.UserManager;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.User;
import application.vacation.model.Vacation;
 
@ManagedBean
public class VacationView {
	
	@EJB
	UserManager userManager;	
	@EJB
	VacationManager vacationManager;
     
	public Vacation vacation;
    static String substitute;
    List<User> users;
    static Date start;
    static Date end;
    MailBean mailBean = new MailBean() ;
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    
    
    
    public String getStringStartDate(){
    	
    	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(start);
    	System.out.println(s.toString());
    	return s.toString();  	
    }
    
 public String getStringEndDate(){
    	
    	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(end);
    	System.out.println(s.toString());
    	return s.toString();  	
    }
 
    
    public Date getStart() {
        return this.start;
    }
 
    public void setStart(Date start) {
        this.start =  start;
    }
 
    public Date getEnd() {
        return this.end;
    }
 
    public void setEnd(Date end) {
        this.end =  end;
    }
    
     
	@PostConstruct
	public void init() {
		
		// users = userManager.findAllUsers();
		vacation = new Vacation();
		vacation.setUser(UserSessionBean.getInstance().getSessionUser());
		if (vacation.getUser() != null) {
			User user = vacation.getUser();
			users = userManager.findAllUsersExclude(user);
		}
	}
 
    public String getSubstitute() {
        return this.substitute;
    }
 
    public void setSubstitute(String substitute) {
        this.substitute = substitute;
    }
 
    public List<User> getUsers() {
        return users;
    }
    
    public String getFullName(User user) {
    	return user.getFirstName() + " " + user.getLastName();
    }
    
    
    
    public void create(ActionEvent event) {
    	System.out.println("start");
    	String name;
    	

    	vacation  = new Vacation();
		vacation.setUser(UserSessionBean.getInstance().getSessionUser());
    	
    	User user=vacation.getUser();

    	List<User> users = userManager.findAllUsersExclude(user);
    	for (User i : users) {
    		name =i.getFirstName() + " " + i.getLastName();
    		if(name.equals(substitute)) {
    			 
    			 System.out.println(vacation.getUser().getFirstName());
    			 
    			 
    			 
    			 vacation.setSubstitute(i);
    			 System.out.println(vacation.getSubstitute().getFirstName());			 

    			 vacation.setStart(start); 
    			 System.out.println(vacation.getStart());
    			 vacation.setEnd(end); 
    			 System.out.println(vacation.getEnd());

    			 vacation.setState("Awaiting approval");

    			 System.out.println(vacation.toString());
  
    			 vacationManager.persistVacation(vacation);
    		}
    	}
    	mailBean.send();
    }
    
    public void create(ActionEvent event,List<User> users) {
    	String name;
    	for (User i : users) {
    		name =i.getFirstName() + " " + i.getLastName();
    		if(name.equals(substitute)) {
    			 vacation  = new Vacation();
    			 vacation.setUser(UserSessionBean.getInstance().getSessionUser());
    			 System.out.println(vacation.getUser().getFirstName());
    			 
    			 vacation.setSubstitute(i);
    			 System.out.println(vacation.getSubstitute().getFirstName());			 
    			 
    			 
    			 vacation.setStart(start); 
    			 System.out.println(vacation.getStart());
    			 vacation.setEnd(end); 
    			 System.out.println(vacation.getEnd());
    			 vacation.setState("Awaiting approval");
    			 
    			 vacationManager.persistVacation(vacation);
    			
    		}
    	}
    }   


	public VacationView() {
		// TODO Auto-generated constructor stub
	}

}
