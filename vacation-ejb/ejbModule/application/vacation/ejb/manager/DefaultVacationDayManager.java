package application.vacation.ejb.manager;

import java.util.List;

import javax.ejb.EJB;

import application.vacation.api.dao.VacationDayDAO;
import application.vacation.api.exception.VacationDayNotFoundException;
import application.vacation.api.manager.VacationDayManager;
import application.vacation.model.VacationDay;

public class DefaultVacationDayManager implements VacationDayManager {
	@EJB
	private VacationDayDAO vacationDayDAO;

	@Override
	public void removeVacationDay(VacationDay vacationDay) {
		vacationDayDAO.removeVacationDay(vacationDay);
	}

	@Override
	public void persistVacationDay(VacationDay vacationDay) {
		vacationDayDAO.persistVacationDay(vacationDay);
	}

	@Override
	public VacationDay mergeVacationDay(VacationDay vacationDay) {
		return vacationDayDAO.mergeVacationDay(vacationDay);
	}

	@Override
	public VacationDay findVacationDay(Long id) throws VacationDayNotFoundException {
		VacationDay vacationDay = vacationDayDAO.findVacationDay(id);
		if (vacationDay == null)
			throw new VacationDayNotFoundException();
		return vacationDay;
	}

	@Override
	public List<VacationDay> findAllVacationDays() {
		return vacationDayDAO.findAllVacationDays();
	}
}
