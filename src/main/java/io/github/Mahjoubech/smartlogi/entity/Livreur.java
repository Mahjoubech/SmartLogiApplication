package io.github.Mahjoubech.smartlogi.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "livreurs" )
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
    public Livreur() {}
    public Livreur(String nom, String prenom, String vehicule, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.vehicule = vehicule;
        this.telephone = telephone;
    }
    //getters
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
    //setters
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
