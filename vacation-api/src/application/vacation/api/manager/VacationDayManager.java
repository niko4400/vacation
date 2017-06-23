package application.vacation.api.manager;

import java.util.List;

import javax.ejb.Remote;

import application.vacation.api.exception.VacationDayNotFoundException;
import application.vacation.model.VacationDay;

@Remote
public interface VacationDayManager {

	VacationDay findVacationDay(Long id) throws VacationDayNotFoundException;
	List<VacationDay> findAllVacationDays() throws VacationDayNotFoundException;;
	VacationDay mergeVacationDay(VacationDay vacationDay);
	void persistVacationDay(VacationDay vacationDay);
	void removeVacationDay(VacationDay vacationDay);
}
