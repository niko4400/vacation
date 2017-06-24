package application.vacation.model;

import application.vacation.model.Vacation;
import java.io.Serializable;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: VacationDay
 *
 */
@NamedQueries({
    @NamedQuery(
            name = "VacationDay.findAllOrdered",
            query = "SELECT vacationDay FROM VacationDay vacationDay ORDER BY vacationDay.id ASC")
})

@Entity
public class VacationDay implements Serializable {

	   
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	private Integer day;
	private Integer month;
	private Integer year;
	@ManyToOne
	@JoinColumn(name = "ID_VACATION")
	private Vacation vacation;
	private static final long serialVersionUID = 1L;

	public VacationDay() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}   
	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}   
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}   
	public Vacation getVacation() {
		return this.vacation;
	}

	public void setVacation(Vacation vacation) {
		this.vacation = vacation;
	}
   
}
