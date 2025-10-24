package io.github.Mahjoubech.smartlogi.service;

import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Livreur;

import java.util.List;
import java.util.Optional;

public interface LivreurService {
    Livreur createLivreur(LivreurDto livreurDto);
    List<Livreur> getAllLivreurs();
    Optional<Livreur> getLivreurById(Long id);
    Livreur updateLivreur(Long id, LivreurDto livreurDto);
    void deleteLivreur(Long id);
    Optional<Livreur> getLivreurByTelephone(String telephone);
     List<Livreur> getLivreursByVehicule(String vehicule);
}
