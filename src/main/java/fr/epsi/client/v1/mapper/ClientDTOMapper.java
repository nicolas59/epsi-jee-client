package fr.epsi.client.v1.mapper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.function.Function;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.epsi.client.entity.Adresse;
import fr.epsi.client.entity.Client;
import fr.epsi.client.v1.dto.AdresseDTO;
import fr.epsi.client.v1.dto.ClientDTO;

@Named
public class ClientDTOMapper implements Function<ClientDTO, Client> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDTOMapper.class);

    @Override
    public Client apply(ClientDTO t) {
        Client client = new Client();
        client.setCivilite(t.getCivilite());
        client.setDateNaissance(t.getDateNaissance());
        client.setEmail(t.getEmail());
        client.setNom(t.getNom());
        client.setPrenom(t.getPrenom());

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(t.getMotDePasse()
                .getBytes(StandardCharsets.UTF_8));

            client.setMotDePasse(Base64.getEncoder()
                .encodeToString(encodedhash));
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Probleme lors du hash", e);
        }

        if (t.getAdresseDomicile() != null) {
            Adresse adresse = mapAdresse(t.getAdresseDomicile());
            adresse.setType(Adresse.Type.DOMICILE);
            adresse.setClient(client);
        }

        if (t.getAdresseLivraison() != null) {
            Adresse adresse = mapAdresse(t.getAdresseDomicile());
            adresse.setType(Adresse.Type.LIVRAISON);
            adresse.setClient(client);
        }

        return client;
    }

    private Adresse mapAdresse(AdresseDTO adresseDTO) {
        Adresse adresse = new Adresse();
        adresse.setComplement(adresseDTO.getComplement());
        adresse.setCp(adresseDTO.getCp());
        adresse.setNumero(adresseDTO.getNumero());

        adresse.setVille(adresseDTO.getVille());
        adresse.setVoie(adresseDTO.getVoie());
        return adresse;
    }

}
