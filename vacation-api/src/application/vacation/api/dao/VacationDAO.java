package application.vacation.api.dao;


import java.util.List;

import application.vacation.model.Vacation;

public interface VacationDAO {

	Vacation findVacation(Long id);
	List<Vacation> findAllVacations();
	Vacation mergeVacation(Vacation vacation);
	void persistVacation(Vacation vacation);
	void removeVacation(Vacation vacation);
	
}
