package fr.epsi.client.v1.dto;

import java.util.Date;

public class ClientDTO {

  private Long id;
  
  private String civilite;
  
  private String nom;
  
  private String prenom;
  
  private Date dateNaissance;
  
  private AdresseDTO adresseDomicile;
  
  private AdresseDTO adresseLivraison;
  
  private Date dernierModification;
  
  private Date dateCreation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCivilite() {
    return civilite;
  }

  public void setCivilite(String civilite) {
    this.civilite = civilite;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public AdresseDTO getAdresseDomicile() {
    return adresseDomicile;
  }

  public void setAdresseDomicile(AdresseDTO adresseDomicile) {
    this.adresseDomicile = adresseDomicile;
  }

  public AdresseDTO getAdresseLivraison() {
    return adresseLivraison;
  }

  public void setAdresseLivraison(AdresseDTO adresseLivraison) {
    this.adresseLivraison = adresseLivraison;
  }

  public Date getDernierModification() {
    return dernierModification;
  }

  public void setDernierModification(Date dernierModification) {
    this.dernierModification = dernierModification;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }
  
  
}
