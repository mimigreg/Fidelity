package fr.michot.fidelity.services;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.fidelity.beans.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestClientService {

	@Inject
	ClientService service;
	
	@Test
	public void testCRUD() {
		// Create
		// on prend comme principe que 0L est réservé aux tests unitaires
		Client film = new Client();
		film = service.setClient(film);
		Client film2 = new Client();
		film2 = service.setClient(film2);
		Client film3 = new Client();
		film3 = service.setClient(film3);
		Assert.assertNotNull("Le film ne devrait pas être null",film);
		Assert.assertNotEquals("Les identifiants devraient être différents", film.getId(), film2.getId());
		// Update
		film3.setNom("bob");		
		film3 = service.setClient(film3);

		// Research
		film = service.getClientParId(film3.getId());
		Assert.assertNotNull("Le film devrait être trouve",film);
		Assert.assertEquals("La note aurait du être modifié", "bob", film.getNom());
		
		// Delete
		service.deleteClient(film.getId());
		List<Client> listeResultante = service.getClientsParTitre("Matrix");
		Assert.assertEquals("On devrait trouver une liste vide", 0,listeResultante.size());
		listeResultante = service.getClientsParTitre("Mad Max");
		Assert.assertEquals("On devrait trouver le film", 1,listeResultante.size());
	}
	
	@Test
	public void testDeleteAll() {
		List<Client> liste = service.getAllClients();
		for (Iterator<Client> iterator = liste.iterator(); iterator.hasNext();) {
			service.deleteClient(iterator.next().getId());
		}
		List<Client> listeResultante = service.getAllClients();
		Assert.assertEquals("On devrait trouver une liste vide",0, listeResultante.size());		
	}

}
