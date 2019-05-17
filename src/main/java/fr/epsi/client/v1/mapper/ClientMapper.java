package fr.epsi.client.v1.mapper;

import java.util.function.Function;

import javax.inject.Named;

import fr.epsi.client.entity.Adresse;
import fr.epsi.client.entity.Client;
import fr.epsi.client.v1.dto.AdresseDTO;
import fr.epsi.client.v1.dto.ClientDTO;

@Named
public class ClientMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client t) {
        ClientDTO client = new ClientDTO();
        client.setCivilite(t.getCivilite());
        client.setDateNaissance(t.getDateNaissance());
        client.setEmail(t.getEmail());
        client.setNom(t.getNom());
        client.setPrenom(t.getPrenom());

        if(t.getAdresses() !=null) {
            t.getAdresses().forEach(adresse -> {
                AdresseDTO dto = mapAdresse(adresse);
                if(Adresse.Type.DOMICILE.equals(adresse.getType())){
                    client.setAdresseDomicile(dto); 
                }else {
                    client.setAdresseLivraison(dto); 
                }
            });
        }
        return client;
    }

    private AdresseDTO mapAdresse(Adresse adresseDTO) {
        AdresseDTO adresse = new AdresseDTO();
        adresse.setComplement(adresseDTO.getComplement());
        adresse.setCp(adresseDTO.getCp());
        adresse.setNumero(adresseDTO.getNumero());

        adresse.setVille(adresseDTO.getVille());
        adresse.setVoie(adresseDTO.getVoie());
        return adresse;
    }
}
