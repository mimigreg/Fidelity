package fr.michot.fidelity.beans;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

/**
 * Entity implementation class for Entity: Film
 * 
 */
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6466214509077244797L;

	@Id
	private String id;

	private String nom;
	
	private DateTime dateArrivee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public DateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(DateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}	

}
