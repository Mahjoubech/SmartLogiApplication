package io.github.Mahjoubech.smartlogi.service;

import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.entity.Livreur;

import java.util.List;
import java.util.Optional;

public interface ColisService {
    Colis createColis(ColisDto colisDto);
    List<Colis> getAllColis();
    Optional<Colis> getColisById(Long id);
    Colis updateColis(Long id, ColisDto colisDto);
    void deleteColis(Long id);
    List<Colis> getColisByLivreurId(Long livreurId);
}
