package fr.epsi.client.v1.dto;

public class AdresseDTO {

  private Long id;
  
  private String numero;
  
  private String voie;
  
  private String complement;
  
  private String cp;
  
  private String ville;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getVoie() {
    return voie;
  }

  public void setVoie(String voie) {
    this.voie = voie;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }
  
  
}
