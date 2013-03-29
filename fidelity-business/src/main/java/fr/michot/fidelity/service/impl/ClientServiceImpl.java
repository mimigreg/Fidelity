package fr.michot.fidelity.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import fr.michot.fidelity.db.Client;

public class ClientServiceImpl {
	public static final int NUMBER_OF_ROWS = 100;
	
	@PersistenceContext
	EntityManager em;

	/**
	 * @param firstName
	 * @param givenName
	 * @param homePhone
	 * @param cellPhone
	 * @param homeAddress
	 * @param email
	 * @param birthDate
	 * @param membershipDate
	 */
	@Transactional
	public Client createNew(String name, 
			String homePhone, String cellPhone, String homeAddress,String email,
			Date birthDate, Date membershipDate) {
		Client aClient = new Client(name, homePhone, cellPhone,
				homeAddress, email, birthDate, membershipDate);
		em.persist(aClient);
		return aClient;
	}
	
	@Transactional
	public List<Client> searchByGivenName(String name) {
		if(name==null) return new ArrayList<Client>();
		
		TypedQuery<Client> uneRequete = em.createQuery("SELECT cli FROM Client cli WHERE cli.name LIKE :name", Client.class);
		uneRequete.setParameter("name", name);
		uneRequete.setMaxResults(NUMBER_OF_ROWS);
		return uneRequete.getResultList();		
	}
	
	@Transactional
	public List<Client> searchByBirthDate(Date date) {
		if(date==null) return new ArrayList<Client>();
		
		TypedQuery<Client> uneRequete = em.createQuery("SELECT cli FROM Client cli WHERE cli.birthDate = :date", Client.class);
		uneRequete.setParameter("date", date);
		uneRequete.setMaxResults(NUMBER_OF_ROWS);
		return uneRequete.getResultList();		
	}

}
