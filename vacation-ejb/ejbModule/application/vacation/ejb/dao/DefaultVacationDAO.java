package application.vacation.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import application.vacation.api.dao.VacationDAO;
import application.vacation.model.Vacation;
@Stateless
public class DefaultVacationDAO implements VacationDAO {
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Vacation findVacation(Long id) {
		return entityManager.find(Vacation.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Vacation> findAllVacations() {
		return entityManager.createNamedQuery("Vacation.findAllOrdered").getResultList();
	}

	@Override
	public Vacation mergeVacation(Vacation vacation) {
		return entityManager.merge(vacation);
	}
	
	@Override
	public void persistVacation(Vacation vacation) {
		entityManager.persist(vacation);
	}

	@Override
	public void removeVacation(Vacation vacation) {
		entityManager.remove(vacation);
	}



}
