package fr.epsi.client.v1.resources;

import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.PathParam;

import fr.epsi.client.v1.dto.ClientDTO;
import fr.epsi.client.v1.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Client", produces = "application/json")
public class ClientResource {

  private ClientService clientService;
  
  /**
   * Permet de reécuperer le client par son id
   * 
   * @param clientId
   * @return
   */
  @ApiOperation(value="Permet de reécuperer le client par son id", httpMethod="GET")
  public ClientDTO getClient(@ApiParam(name="id") @PathParam("id" )Long clientId) {
    return clientService.getClient(clientId);
  }

  /**
   * Retourne la liste des clients
   * 
   * @return
   */
  public Collection<ClientDTO> getAllClients() {
    return clientService.getAllClients();
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
   * @param clientId
   */
  public void deleteClient(Long clientId) {
    
  }
}
