package application.vacation.web.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import application.vacation.api.exception.VacationNotFoundException;
import application.vacation.api.manager.UserManager;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.User;
import application.vacation.model.Vacation;

@ManagedBean
public class ManagerView {
	
	@EJB
	VacationManager vacationManager;
     
	private Vacation vacation;
    List<Vacation> vacations;
    
    
	@PostConstruct
	public void init() throws VacationNotFoundException {
		vacations=getAllVacations();
	}
	
	public Vacation getVacation(){
		return this.vacation;
	}
	public void setVacation(Vacation vacation){
		this.vacation=vacation;
	}
	public List<Vacation> getVacations(){
		return this.vacations;
	}
	public void setVacation(List<Vacation> vacations){
		this.vacations=vacations;
	}
	
	public List<Vacation> getAllVacations() throws VacationNotFoundException{
		return vacationManager.findAllVacations();
	}
	
	public Vacation getVacationById(long id) throws VacationNotFoundException{
		return vacationManager.findVacation(id);
	}
	
	 public String vacationToString(Vacation vacation) {
	    	return vacation.getUser()+","+vacation.getSubstitute()+","+vacation.toString();
	    }


	public void approve(Vacation vacation) {

		vacation.setState("Approved");
		vacationManager.mergeVacation(vacation);
	}
	
	public void reject(Vacation vacation) {

		vacation.setState("Rejected");
		vacationManager.mergeVacation(vacation);
	}
	
	public ManagerView(){
		
	}
	
}
