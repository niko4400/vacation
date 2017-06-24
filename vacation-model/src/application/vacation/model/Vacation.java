package application.vacation.model;

import application.vacation.model.User;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

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


//TODO Query
/**
 * Entity implementation class for Entity: Vacation
 *
 */

@NamedQueries({
    @NamedQuery(
            name = "Vacation.findAllOrdered",
            query = "SELECT vacation FROM Vacation vacation ORDER BY vacation.id ASC")
})

@Entity
public class Vacation implements Serializable {

	   
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;
	@ManyToOne
	@JoinColumn(name = "ID_SUBSTITUTE")
	private User substitute;
	private String state;
	private static final long serialVersionUID = 1L;
	private Date start;
	private Date end;
	
	public void setStart(Date start){
		this.start=start;
	}
	public Date getStart(){
		return this.start;
	}
	public void setEnd(Date end){
		this.end=end;
	}
	public Date getEnd(){
		return this.end;
	}
	
	
	public Vacation() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
