package esprit.pi.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.registry.infomodel.User;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	
	
	private int id;
	private String Nom;
	private int Prix;

	private int Duree;
	private String Lieu;
	private Date Date_Debut;
	private String Description;
	private String Type;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	

	
	

	public int getPrix() {
		return Prix;
	}

	public void setPrix(int prix) {
		Prix = prix;
	}

	
	
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}


	
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public int getDuree() {
		return this.Duree;
	}

	public void setDuree(int Duree) {
		this.Duree = Duree;
	}   
	public String getLieu() {
		return this.Lieu;
	}

	public void setLieu(String Lieu) {
		this.Lieu = Lieu;
	}   
	public Date getDate_Debut() {
		return this.Date_Debut;
	}

	public void setDate_Debut(Date Date_Debut) {
		this.Date_Debut = Date_Debut;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
