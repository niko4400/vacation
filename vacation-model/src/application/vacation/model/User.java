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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: User
 *
 */
@NamedQueries({
    @NamedQuery(
            name = "User.findAllOrdered",
            query = "SELECT user FROM User user ORDER BY user.id ASC")
})


@Entity
public class User implements Serializable {

	   
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )	
	private Long id;	
	
	@Size(min=2, max=20)
	private String login;
	
	private String password;
	
	@Size(min=2, max=20)
	@Pattern(regexp="^[\\p{L} .'-]+$",
    message=" tylko litery ")
	private String jobTitle;
	
	private static final long serialVersionUID = 1L;
	
	@Size(min=2, max=20)
	@Pattern(regexp="^[\\p{L} .'-]+$",
	             message=" tylko litery ")
	private String firstName;
	
	@Size(min=2, max=20)
	@Pattern(regexp="^[\\p{L} .'-]+$",
    message=" tylko litery ")
	private String lastName;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message=" prawid³owy format maila to x@hosting.pl ")
	private String email;

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
  
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
   
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
	@Override
	public String toString(){
	return this.firstName+" "+this.lastName;
	}
	
}