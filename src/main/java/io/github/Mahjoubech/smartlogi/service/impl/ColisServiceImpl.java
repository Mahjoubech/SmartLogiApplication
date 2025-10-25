package io.github.Mahjoubech.smartlogi.service.impl;

import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.entity.Livreur;
import io.github.Mahjoubech.smartlogi.exception.LivreurNotFoundException;
import io.github.Mahjoubech.smartlogi.repository.ColisRepository;
import io.github.Mahjoubech.smartlogi.service.ColisService;

import java.util.List;
import java.util.Optional;

public class ColisServiceImpl implements ColisService {
    private  final ColisRepository colisRepository;
    public ColisServiceImpl(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }
    @Override
    public Colis createColis(ColisDto colissDto){
        Colis colis = new Colis(
                colissDto.getDestinataire(),
                colissDto.getAdresse(),
                colissDto.getPoids(),
                colissDto.getStatutColis(),
                colissDto.getLivreur()
        );
        return colisRepository.save(colis);
    }

    @Override
    public Colis updateColis(Long id, ColisDto colisDto){
        return  colisRepository.findById(id).map(colis->{
            colis.setDestinataire(colisDto.getDestinataire());
            colis.setAdresse(colisDto.getAdresse());
            colis.setPoids(colisDto.getPoids());
            colis.setStatut(colisDto.getStatutColis());
            colis.setLivreur(colisDto.getLivreur());
            return colisRepository.save(colis);
        }).orElseThrow(() -> new LivreurNotFoundException("Colis non trouvé avec ID: " + id)); // ✅ استخدام الاستثناء المخصص
    }

    @Override
    public  void deleteColis(Long id){
        if (!colisRepository.existsById(id)) {
            throw new LivreurNotFoundException("Suppression échouée: colid non trouvé avec ID: " + id);
        }colisRepository.deleteById(id);
    }

    @Override
    public List<Colis> getAllColis(){
        return colisRepository.findAll();
    }

    @Override
    public Optional<Colis> getColisById(Long id){
        if (!colisRepository.existsById(id)) {
            throw new LivreurNotFoundException("not fond this livreur: " + id);
        }
        return colisRepository.findById(id);
    }
  @Override
        public List<Colis> getColisByLivreurId(Long livreurId){
        return colisRepository.findByLivreurId(livreurId);
    }

}
