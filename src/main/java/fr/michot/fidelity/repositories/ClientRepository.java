package fr.michot.fidelity.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.michot.fidelity.beans.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
	List<Client> findByNom(String titre);
}
