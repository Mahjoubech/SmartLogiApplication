package io.github.Mahjoubech.smartlogi.entity;

import io.github.Mahjoubech.smartlogi.enums.StatutColis;
import jakarta.persistence.*;

public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destinataire", nullable = false)
    private String destinataire;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "poids")
    private Double poids;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private StatutColis statut = StatutColis.PREPARATION;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livreur_id")
    private Livreur livreur;

    public Colis() {}
    public Colis(String destinataire, String adresse, Double poids, StatutColis statut, Livreur livreur) {
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.poids = poids;
        this.statut = statut;
        this.livreur = livreur;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public StatutColis getStatut() {
        return statut;
    }

    public void setStatut(StatutColis statut) {
        this.statut = statut;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "id=" + id +
                ", destinataire='" + destinataire + '\'' +
                ", adresse='" + adresse + '\'' +
                ", poids=" + poids +
                ", statut=" + statut +
                ", livreur=" + (livreur != null ? livreur.getNom() + ' ' + livreur.getPrenom() : null) +
                '}';
    }
}
