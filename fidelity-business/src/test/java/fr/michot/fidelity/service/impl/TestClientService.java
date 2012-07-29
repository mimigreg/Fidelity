package fr.michot.fidelity.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.fidelity.db.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestClientService {
	
	@Inject
	ClientServiceImpl cService;

	@Test
	public void testCreate() {
		Client unClient = cService.createNew("Grégory", "Michot", "+33 1 02 03 04 05", "+33 6 02 03 04 05", "1, rue de la guillotine 75008 Paris","somewhere@inthe.earth", new DateTime(1976,11,6,14,0).toDate(), new DateTime(2012,07,6,17,0).toDate());
		Assert.assertNotNull(unClient);
		cService.createNew("Wen-Hsiu", "Michot", "+33 1 02 03 04 05", "+33 6 05 04 03 02", "1, rue de la guillotine 75008 Paris","somewherehere@inthe.earth", new DateTime(1978,3,8,14,0).toDate(), new DateTime(2012,07,16,20,0).toDate());
	}

	@Test
	public void testResearch() {
		List<Client> listeClient = cService.searchByGivenName("Michot");
		Assert.assertNotNull(listeClient);
		Assert.assertTrue(listeClient.size()>0);
	}

}
