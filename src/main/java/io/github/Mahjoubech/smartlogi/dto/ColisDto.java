package io.github.Mahjoubech.smartlogi.dto;

public class ColisDto {
    private String destinataire;
    private String adresse;
    private Double poids;
    private Long livreurId;
    public ColisDto() {}
    public ColisDto(String destinataire, String adresse, Double poids, Long livreurId) {
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.poids = poids;
        this.livreurId = livreurId;
    }
    public String getDestinataire() { return destinataire; }
    public void setDestinataire(String destinataire) { this.destinataire = destinataire; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Double getPoids() { return poids; }
    public void setPoids(Double poids) { this.poids = poids; }

    public Long getLivreurId() { return livreurId; }
    public void setLivreurId(Long livreurId) { this.livreurId = livreurId; }
}
