package application.vacation.model;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: User
 *
 */ 
public class UserPK  implements Serializable {   
   
	         
	private int id;         
	private String name;         
	private String password;         
	private String title;
	private static final long serialVersionUID = 1L;

	public UserPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof UserPK)) {
			return false;
		}
		UserPK other = (UserPK) o;
		return true
			&& getId() == other.getId()
			&& (getName() == null ? other.getName() == null : getName().equals(other.getName()))
			&& (getPassword() == null ? other.getPassword() == null : getPassword().equals(other.getPassword()))
			&& (getTitle() == null ? other.getTitle() == null : getTitle().equals(other.getTitle()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		result = prime * result + (getName() == null ? 0 : getName().hashCode());
		result = prime * result + (getPassword() == null ? 0 : getPassword().hashCode());
		result = prime * result + (getTitle() == null ? 0 : getTitle().hashCode());
		return result;
	}
   
   
}
