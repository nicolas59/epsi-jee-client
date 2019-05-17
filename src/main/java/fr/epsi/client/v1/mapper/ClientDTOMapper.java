package fr.epsi.client.v1.mapper;

import java.util.function.Function;

import javax.inject.Named;

import fr.epsi.client.entity.Client;
import fr.epsi.client.v1.dto.ClientDTO;

@Named
public class ClientDTOMapper implements Function<ClientDTO, Client> {

  @Override
  public Client apply(ClientDTO t) {
    // TODO Auto-generated method stub
    return null;
  }

}
