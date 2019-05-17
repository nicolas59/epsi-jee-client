package fr.epsi.client.v1.mapper;

import java.util.function.Function;

import javax.inject.Named;

import fr.epsi.client.entity.Client;
import fr.epsi.client.v1.dto.ClientDTO;

@Named
public class ClientMapper implements Function<Client, ClientDTO> {

  @Override
  public ClientDTO apply(Client t) {
    // TODO Auto-generated method stub
    return null;
  }

}
