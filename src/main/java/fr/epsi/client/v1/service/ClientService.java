package fr.epsi.client.v1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import fr.epsi.client.entity.Client;
import fr.epsi.client.repository.ClientRepository;
import fr.epsi.client.v1.dto.ClientDTO;
import fr.epsi.client.v1.mapper.ClientDTOMapper;
import fr.epsi.client.v1.mapper.ClientMapper;

public class ClientService {

  private ClientRepository clientRepository;

  private ClientDTOMapper mapperDto;

  private ClientMapper mapper;

  /**
   * Permet de reécuperer le par son id
   * 
   * @param clientId
   * @return
   */
  public ClientDTO getClient(Long clientId) {
    Client client = this.clientRepository.findById(clientId)
      .orElseThrow(() -> new NotFoundException("Client non trouvé"));
    return this.mapper.apply(client);
  }

  /**
   * Retourne la liste des clients
   * 
   * @return
   */
  public Collection<ClientDTO> getAllClients() {
    List<ClientDTO> clients = new ArrayList<>();
    this.clientRepository.findAll().forEach(c -> this.mapper.apply(c));
    return clients;
  }

  /**
   * Permet de créer un nouveau client
   * 
   * @param clientDto
   */
  // TODO Modifier le Void afin que le service Rest retourne : un code 201 et en
  // entete l'url pour aller récupérer le client
  public void createClient(@Valid ClientDTO clientDto) {

  }

  /**
   * Permet de supprimer un client
   * 
   * @param clientId
   */
  public void deleteClient(Long clientId) {

  }
  
  
  public ClientDTO getClient(String login, String password) {
      return null;
  }
}
