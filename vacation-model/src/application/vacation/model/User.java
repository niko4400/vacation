package application.vacation.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

@IdClass(UserPK.class)
public class User implements Serializable {

	   
	@Id
	private int id;   
	@Id
	private String name;   
	@Id
	private String password;   
	@Id
	private String title;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
}
