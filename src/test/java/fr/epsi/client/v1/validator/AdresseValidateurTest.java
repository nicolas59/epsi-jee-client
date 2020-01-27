package fr.epsi.client.v1.validator;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import fr.epsi.client.v1.dto.AdresseDTO;

public class AdresseValidateurTest {

    @Test
    public void should_get_violations() {
        AdresseDTO adresseDTO = new AdresseDTO();

        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<AdresseDTO>> violations = validator.validate(adresseDTO);

        assertThat(violations.size()).isNotZero();

        List<String> messages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .map(String::trim)
            .collect(toList());
        assertThat(messages).contains("Le numéro doit être renseigné");
        assertThat(messages).contains("La voie doit être renseignée");
        assertThat(messages).contains("Le code postal est obligatoire");
        assertThat(messages).contains("La ville est obligatoire");
    }
    
    
    @Test
    public void should_get_violations_when_numero_is_malformed() {
        AdresseDTO adresseDTO = new AdresseDTO();
        adresseDTO.setNumero("12345678900987654321");

        Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
        Set<ConstraintViolation<AdresseDTO>> violations = validator.validate(adresseDTO);

        assertThat(violations.size()).isNotZero();

        List<String> messages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .map(String::trim)
            .collect(toList());
        assertThat(messages).contains("Le numéro ne peut exceder 10 caractères");
    }
    
}
