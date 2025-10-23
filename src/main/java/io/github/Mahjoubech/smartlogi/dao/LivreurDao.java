package io.github.Mahjoubech.smartlogi.dao;

import io.github.Mahjoubech.smartlogi.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivreurDao extends JpaRepository<Livreur , Long> {
    Optional<Livreur> getLivreursByTelephone(String telephone);
}
