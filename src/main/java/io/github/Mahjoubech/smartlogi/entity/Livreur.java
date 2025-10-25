package io.github.Mahjoubech.smartlogi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livreur")
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "vehicule")
    private String vehicule;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @OneToMany(mappedBy = "livreur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Colis> colisList = new ArrayList<>();


    public Livreur() {}

    public Livreur(String nom, String prenom, String vehicule, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.vehicule = vehicule;
        this.telephone = telephone;
    }


    // Getters
    public Long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getVehicule() {
        return vehicule;
    }
    public String getTelephone() {
        return telephone;
    }
    public List<Colis> getColisList() {
        return colisList;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setColisList(List<Colis> colisList) {
        this.colisList = colisList;
    }

    public void addColis(Colis colis) {
        colisList.add(colis);
        colis.setLivreur(this);
    }


    @Override
    public String toString() {
        return "Livreur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", vehicule='" + vehicule + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}