package fr.epsi.client.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epsi.client.entity.Client;

/**
 * Exemple avec utilisation d'un DAO
 * 
 * @author nrousseau1
 *
 */
@Named
public class ClientDAO {

  @PersistenceContext
  private EntityManager em;

  public List<Client> getAllClients() {
    return this.em.createQuery("from Client")
      .getResultList();
  }

  public Client findClientBy(Long id) {
    //Solution courte
    return this.em.find(Client.class, id);
    
    // Solution longue
   /* return (Client) this.em.createQuery("from Client where id=:id")
      .setParameter("id", id)
      .getSingleResult();*/
  }
}
