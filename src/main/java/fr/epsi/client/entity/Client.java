package fr.epsi.client.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{

    @Id
    private Long id;

    private String civilite;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private Date dernierModification;

    private Date dateCreation;

    private String email;

    private String motDePasse;
    
    @OneToMany(mappedBy="client")
    private List<Adresse> adresses;

    /**
     * @return the adresses
     */
    public List<Adresse> getAdresses() {
        return adresses;
    }

    /**
     * @param adresses the adresses to set
     */
    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the civilite
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * @param civilite the civilite to set
     */
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    /**
     * @return the dernierModification
     */
    public Date getDernierModification() {
        return dernierModification;
    }

    /**
     * @param dernierModification the dernierModification to set
     */
    public void setDernierModification(Date dernierModification) {
        this.dernierModification = dernierModification;
    }

    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    

}
