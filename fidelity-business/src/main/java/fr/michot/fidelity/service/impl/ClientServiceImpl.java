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
	public Client createNew(String firstName, String givenName,
			String homePhone, String cellPhone, String homeAddress,String email,
			Date birthDate, Date membershipDate) {
		Client aClient = new Client(firstName, givenName, homePhone, cellPhone,
				homeAddress, email, birthDate, membershipDate);
		em.persist(aClient);
		return aClient;
	}
	
	@Transactional
	public List<Client> searchByGivenName(String givenName) {
		if(givenName==null) return new ArrayList<Client>();
		
		TypedQuery<Client> uneRequete = em.createQuery("SELECT cli FROM Client cli WHERE cli.givenName LIKE :givenName", Client.class);
		uneRequete.setParameter("givenName", givenName+"%");
		return uneRequete.setMaxResults(50).getResultList();		
	}

}
