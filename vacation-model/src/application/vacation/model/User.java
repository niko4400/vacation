package application.vacation.model;

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
 * Entity implementation class for Entity: User
 *
 */

@NamedQueries({
	@NamedQuery(
			name = "User.findAllOrdered", 
			query = "SELECT user FROM User user ORDER BY user.name ASC"),
	@NamedQuery(
			name = "User.findByLastName", 
			query = "SELECT user FROM User user WHERE user.name = :name")
})

@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	private String login;
	private String password;
	private String name;
	private String title;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
}
