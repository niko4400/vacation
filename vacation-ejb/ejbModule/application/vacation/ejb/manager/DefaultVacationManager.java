package application.vacation.ejb.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import application.vacation.api.dao.VacationDAO;
import application.vacation.api.exception.VacationNotFoundException;
import application.vacation.api.manager.VacationManager;
import application.vacation.model.Vacation;
@Stateless
public class DefaultVacationManager implements VacationManager {

	@EJB
	private VacationDAO vacationDAO;

	@Override
	public void removeVacation(Vacation vacation) {
		vacationDAO.removeVacation(vacation);
	}

	@Override
	public void persistVacation(Vacation vacation) {
		vacationDAO.persistVacation(vacation);
	}

	@Override
	public Vacation mergeVacation(Vacation vacation) {
		return vacationDAO.mergeVacation(vacation);
	}

	@Override
	public Vacation findVacation(Long id) throws VacationNotFoundException {
		Vacation vacation = vacationDAO.findVacation(id);
		if (vacation == null)
			throw new VacationNotFoundException();
		return vacation;
	}

	@Override
	public List<Vacation> findAllVacations() {
		return vacationDAO.findAllVacations();
	}
	
	
}
