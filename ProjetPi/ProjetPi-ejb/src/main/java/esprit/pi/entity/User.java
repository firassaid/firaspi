package esprit.pi.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity(name="User")

public class User implements Serializable {

	   
	private String Sexe;
	
	private int id;
	private String Nom;
	private Event eventt;
	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}   
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}  
	

	public Event getEvent() {
		return eventt;
	}
	public void setEvent(Event eventt) {
		this.eventt = eventt;
	}

	

	
	 
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public String getSexe() {
		return this.Sexe;
	}

	public void setSexe(String Sexe) {
		this.Sexe = Sexe;
	}
   
}
