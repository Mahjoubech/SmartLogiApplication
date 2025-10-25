package io.github.Mahjoubech.smartlogi.dto;

import io.github.Mahjoubech.smartlogi.entity.Livreur;
import io.github.Mahjoubech.smartlogi.enums.StatutColis;

public class ColisDto {
    private String destinataire;
    private String adresse;
    private Double poids;
    private Livreur livreur;
    private StatutColis statutColis;
    public ColisDto() {}
    public ColisDto(String destinataire, String adresse, Double poids,StatutColis statutColis, Livreur livreur) {
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.poids = poids;
        this.statutColis=statutColis;
        this.livreur = livreur;
    }
    public String getDestinataire() { return destinataire; }
    public void setDestinataire(String destinataire) { this.destinataire = destinataire; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Double getPoids() { return poids; }
    public void setPoids(Double poids) { this.poids = poids; }
    public StatutColis getStatutColis() { return statutColis; }
    public void setStatutColis(StatutColis statutColis) { this.statutColis = statutColis; }
    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
