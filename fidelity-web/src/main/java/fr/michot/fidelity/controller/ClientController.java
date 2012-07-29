package fr.michot.fidelity.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.michot.fidelity.db.Client;
import fr.michot.fidelity.service.impl.ClientServiceImpl;
import fr.michot.fidelity.viewModel.ListClientView;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Inject
	ClientServiceImpl cService;

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	ListClientView getClientList(@PathVariable String name) {

		List<Client> listClient = cService.searchByGivenName(name);
		
		return ListClientView.fromDatabaseClient(listClient);
	}

}
