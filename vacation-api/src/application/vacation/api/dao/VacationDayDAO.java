package application.vacation.api.dao;

import java.util.List;

import application.vacation.model.VacationDay;

public interface VacationDayDAO {

	VacationDay findVacationDay(Long id);
	List<VacationDay> findAllVacationDays();
	VacationDay mergeVacationDay(VacationDay vacationDay);
	void persistVacationDay(VacationDay vacationDay);
	void removeVacationDay(VacationDay vacationDay);
	
}
