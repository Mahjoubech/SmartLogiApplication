package io.github.Mahjoubech.smartlogi.service.impl;

import io.github.Mahjoubech.smartlogi.repository.ColisRepository;
import io.github.Mahjoubech.smartlogi.repository.LivreurRepository;
import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.entity.Livreur;
import io.github.Mahjoubech.smartlogi.service.ColisService;
import io.github.Mahjoubech.smartlogi.exception.LivreurNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ColisServiceImpl implements ColisService {
    private final ColisRepository colisRepository;
    private final LivreurRepository livreurRepository;
    public ColisServiceImpl(ColisRepository colisRepository, LivreurRepository livreurRepository) {
        this.colisRepository = colisRepository;
        this.livreurRepository = livreurRepository;
    }

    @Override
    public Colis createColis(ColisDto colissDto){
        Livreur livreur = livreurRepository.findById(colissDto.getLivreur().getId())
                .orElseThrow(() -> new LivreurNotFoundException("Livreur non trouvé pour l'assignation avec ID: " + colissDto.getLivreur().getId()));

        Colis colis = new Colis(
                colissDto.getDestinataire(),
                colissDto.getAdresse(),
                colissDto.getPoids(),
                colissDto.getStatutColis(),
                livreur
        );
        return colisRepository.save(colis);
    }

    @Override
    public Colis updateColis(Long id, ColisDto colisDto){

        return colisRepository.findById(id).map(colis->{
            if (colisDto.getLivreur() != null && !colisDto.getLivreur().equals(colis.getLivreur().getId())) {
                Livreur nouveauLivreur = livreurRepository.findById(colisDto.getLivreur().getId())
                        .orElseThrow(() -> new LivreurNotFoundException("Nouveau Livreur non trouvé avec ID: " + colisDto.getLivreur().getId()));
                colis.setLivreur(nouveauLivreur);
            }

            colis.setDestinataire(colisDto.getDestinataire());
            colis.setAdresse(colisDto.getAdresse());
            colis.setPoids(colisDto.getPoids());
            colis.setStatut(colisDto.getStatutColis());

            return colisRepository.save(colis);
        }).orElseThrow(() -> new LivreurNotFoundException("Colis non trouvé avec ID: " + id));
    }

    @Override
    public  void deleteColis(Long id){
        if (!colisRepository.existsById(id)) {
            throw new LivreurNotFoundException("Suppression échouée: Colis non trouvé avec ID: " + id);
        }
        colisRepository.deleteById(id);
    }

    @Override
    public List<Colis> getAllColis(){
        return colisRepository.findAll();
    }

    @Override
    public Optional<Colis> getColisById(Long id){
        Optional<Colis> colis = colisRepository.findById(id);
        if (colis.isEmpty()) {
            throw new LivreurNotFoundException("Colis non trouvé avec ID: " + id);
        }
        return colis;
    }

    @Override
    public List<Colis> getColisByLivreurId(Long livreurId){
        return colisRepository.findByLivreurId(livreurId);
    }
}