package application.vacation.model;

import application.vacation.model.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Vacation
 *
 */
@Entity

public class Vacation implements Serializable {

	   
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id;
	private User user;
	private User substitute;
	private String state;
	private static final long serialVersionUID = 1L;

	public Vacation() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public User getSubstitute() {
		return this.substitute;
	}

	public void setSubstitute(User substitute) {
		this.substitute = substitute;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
   
}
