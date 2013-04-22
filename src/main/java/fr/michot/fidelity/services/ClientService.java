package fr.michot.fidelity.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.michot.fidelity.beans.Client;
import fr.michot.fidelity.repositories.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientService {
	@Inject
	ClientRepository repository;
	
	@RequestMapping(value="nom/{nom}", method = RequestMethod.GET)
	public @ResponseBody List<Client>  getClientsParTitre(@PathVariable String nom) {
		return repository.findByNom(nom);
	}
	
	@RequestMapping(value="id/{id}", method = RequestMethod.GET)
	public @ResponseBody Client  getClientParId(@PathVariable String id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public @ResponseBody List<Client>  getAllClients() {
		ArrayList<Client> clients = new ArrayList<Client>();
		Iterable<Client> iter = repository.findAll();
		for (Client client : iter) {
			clients.add(client);
		}
		return clients;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Client setClient(@RequestBody Client Client) {
		return repository.save(Client);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteClient(@PathVariable String id) {
		repository.delete(id);
		return id;
	}

}
