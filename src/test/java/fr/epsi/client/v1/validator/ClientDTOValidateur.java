package fr.epsi.client.v1.validator;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import fr.epsi.client.v1.dto.ClientDTO;

public class ClientDTOValidateur {

    @Test
    public void should_get_violations() {
        ClientDTO client = new ClientDTO();

        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<ClientDTO>> violations = validator.validate(client);

        assertThat(violations.size()).isNotZero();

        List<String> messages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .map(String::trim)
            .collect(toList());
        assertThat(messages).contains("La civilité doit être renseignée");
        assertThat(messages).contains("Le nom est obligatoire");
        assertThat(messages).contains("Le prenom est obligatoire");
        assertThat(messages).contains("La date de naissance est obligatoire");
        assertThat(messages).contains("L'adresse domicile est obligatoire");
    }
    
    @Test
    public void should_get_violations_when_id_is_not_null() {
        ClientDTO client = new ClientDTO();
        client.setId(1L);

        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<ClientDTO>> violations = validator.validate(client);

        assertThat(violations.size()).isNotZero();

        List<String> messages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .map(String::trim)
            .collect(toList());
        assertThat(messages).contains("L'id ne peut être modifié");
    }
    
    @Test
    public void should_get_violations_when_prenom_is_malformed() {
        ClientDTO client = new ClientDTO();

        client.setNom("       b");
        
        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<ClientDTO>> violations = validator.validate(client);

        assertThat(violations.size()).isNotZero();

        List<String> messages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .map(String::trim)
            .collect(toList());
        assertThat(messages).contains("Le nom doit au minimun contenir 1 caractére et ne doit pas exceder 250 caractères");
    }

    
    @Test
    public void should_get_violation_when_client_is_mineur() {
        ClientDTO client = new ClientDTO();

        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<ClientDTO>> violations = validator.validate(client);

        assertThat(violations.size()).isNotZero();
        List<String> messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .map(String::trim)
                .collect(toList());
        assertThat(messages).contains("Vous devez être majeur");
    }
}

