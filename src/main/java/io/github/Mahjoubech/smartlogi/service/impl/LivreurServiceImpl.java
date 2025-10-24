package io.github.Mahjoubech.smartlogi.service.impl;

import io.github.Mahjoubech.smartlogi.repository.LivreurRepository;
import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Livreur;
import io.github.Mahjoubech.smartlogi.service.LivreurService;
import io.github.Mahjoubech.smartlogi.exception.LivreurNotFoundException;

import java.util.List;
import java.util.Optional;

public class LivreurServiceImpl implements LivreurService {

    private final LivreurRepository livreurRepository;

    public LivreurServiceImpl(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    @Override
    public Livreur createLivreur(LivreurDto livreurDto){
        Livreur livreur = new Livreur(
                livreurDto.getNom(),
                livreurDto.getPrenom(),
                livreurDto.getVehicule(),
                livreurDto.getTelephone()
        );
        return livreurRepository.save(livreur);
    }

    @Override
    public Livreur updateLivreur(Long id, LivreurDto livreurDto){
        return  livreurRepository.findById(id).map(livreur->{
            livreur.setNom(livreurDto.getNom());
            livreur.setPrenom(livreurDto.getPrenom());
            livreur.setVehicule(livreurDto.getVehicule());
            livreur.setTelephone(livreurDto.getTelephone());
            return livreurRepository.save(livreur);
        }).orElseThrow(() -> new LivreurNotFoundException("Livreur non trouvé avec ID: " + id)); // ✅ استخدام الاستثناء المخصص
    }

    @Override
    public  void deleteLivreur(Long id){
        if (!livreurRepository.existsById(id)) {
            throw new LivreurNotFoundException("Suppression échouée: Livreur non trouvé avec ID: " + id);
        }
        livreurRepository.deleteById(id);
    }

    @Override
    public List<Livreur> getAllLivreurs(){
        return livreurRepository.findAll();
    }

    @Override
    public Optional<Livreur> getLivreurById(Long id){
        if (!livreurRepository.existsById(id)) {
            throw new LivreurNotFoundException("not fond this livreur: " + id);
        }
        return livreurRepository.findById(id);
    }

    @Override
    public List<Livreur> getLivreursByVehicule(String vehicule){
        return livreurRepository.findByVehiculeIgnoreCase(vehicule);
    }

    @Override
    public Optional<Livreur> getLivreurByTelephone(String telephone){
        return livreurRepository.findByTelephone(telephone);
    }

}