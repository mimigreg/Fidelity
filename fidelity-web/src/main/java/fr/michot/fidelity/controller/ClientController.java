package fr.michot.fidelity.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.michot.fidelity.db.Client;
import fr.michot.fidelity.service.impl.ClientServiceImpl;
import fr.michot.fidelity.viewModel.ListClientLineView;
import fr.michot.fidelity.viewModel.ListClientView;

@Controller
@RequestMapping("/client")
public class ClientController {

	Logger log = Logger.getLogger(ClientController.class);
	
	@Inject
	ClientServiceImpl cService;

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public @ResponseBody List<ListClientLineView> getClientListByName(@PathVariable String name) {
		log.info(name);
		
		List<Client> listClient = cService.searchByGivenName(name);
		
		return ListClientView.fromDatabaseClient(listClient).getItems();
	}
	
	@RequestMapping(value = "/birthdate/{date}", method = RequestMethod.GET)
	public @ResponseBody List<ListClientLineView> getClientListByBirthDate(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date date) {

		log.info(date);
		
		List<Client> listClient = cService.searchByBirthDate(date);
		
		return ListClientView.fromDatabaseClient(listClient).getItems();
	}

}
