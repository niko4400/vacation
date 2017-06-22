package application.vacation.api.manager;


import java.util.List;

import javax.ejb.Remote;

import application.vacation.api.exception.VacationNotFoundException;
import application.vacation.model.Vacation;


@Remote
public interface VacationManager {

	Vacation findVacation(Long id) throws VacationNotFoundException;
	List<Vacation> findAllVacations() throws VacationNotFoundException;;
	Vacation mergeVacation(Vacation vacation);
	void persistVacation(Vacation vacation);
	void removeVacation(Vacation vacation);
	
}
