package fr.epsi.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.client.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
