package application.vacation.ejb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.vacation.api.dao.VacationDayDAO;
import application.vacation.model.VacationDay;

public class DefaultVacationDayDAO implements VacationDayDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public VacationDay findVacationDay(Long id) {
		return entityManager.find(VacationDay.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<VacationDay> findAllVacationDays() {
		return entityManager.createNamedQuery("VacationDay.findAllOrdered").getResultList();
	}

	@Override
	public VacationDay mergeVacationDay(VacationDay vacationDay) {
		return entityManager.merge(vacationDay);
	}
	
	@Override
	public void persistVacationDay(VacationDay vacationDay) {
		entityManager.persist(vacationDay);
	}

	@Override
	public void removeVacationDay(VacationDay vacationDay) {
		entityManager.remove(vacationDay);
	}
}
