package io.github.Mahjoubech.smartlogi.repository;

import io.github.Mahjoubech.smartlogi.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivreurRepository extends JpaRepository<Livreur , Long> {
    List<Livreur> findByVehiculeIgnoreCase(String vehicule);
    Optional<Livreur> findByTelephone(String telephone);
}
