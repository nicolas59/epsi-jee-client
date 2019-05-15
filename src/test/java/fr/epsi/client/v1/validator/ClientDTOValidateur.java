package fr.epsi.client.v1.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import fr.epsi.client.v1.dto.ClientDTO;

public class ClientDTOValidateur {

  @Test
  public void should_get_violation() {
    ClientDTO client = new ClientDTO();
    
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<ClientDTO>> violations = validator.validate(client);
    
    assertThat(violations.size()).isNotZero();
    
  }
  
}
