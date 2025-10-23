package io.github.Mahjoubech.smartlogi.service;

import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Livreur;

import java.util.List;
import java.util.Optional;

public interface LivreurService {
    Livreur create(LivreurDto livreurDto);
    List<Livreur> getAllLivreurs();
    Optional<Livreur> getLivreurById(Long id);
    Livreur update(Long id, LivreurDto livreurDto);
    void delete(Long id);
}
