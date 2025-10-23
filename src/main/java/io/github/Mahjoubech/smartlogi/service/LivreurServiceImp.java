package io.github.Mahjoubech.smartlogi.service;

import io.github.Mahjoubech.smartlogi.dao.LivreurDao;
import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.entity.Livreur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivreurServiceImp implements LivreurService{
    private final LivreurDao livreurDao;
    public LivreurServiceImp(LivreurDao livreurDao) {
        this.livreurDao = livreurDao;
    }
    @Override
    public Livreur create(LivreurDto livreurDto){
        Livreur livreur = new Livreur(
                livreurDto.getNom(),
                livreurDto.getPrenom(),
                livreurDto.getVehicule(),
                livreurDto.getTelephone()
        );
       return livreurDao.save(livreur);
    }
    @Override
    public Livreur update(Long id, LivreurDto livreurDto){
        return  livreurDao.findById(id).map(livreur->{
                    livreur.setNom(livreurDto.getNom());
                    livreur.setPrenom(livreurDto.getPrenom());
                    livreur.setVehicule(livreurDto.getVehicule());
                    livreur.setTelephone(livreurDto.getTelephone());
                    return livreurDao.save(livreur);
        }).orElseThrow(() -> new RuntimeException("Livreur non trouvé avec ID: " + id));
    }
    @Override
    public  void delete(Long id){
        livreurDao.deleteById(id);
    }
    @Override
    public List<Livreur> getAllLivreurs(){
        return livreurDao.findAll();
    }
    @Override
    public Optional<Livreur> getLivreurById(Long id){
        return livreurDao.findById(id);
    }
    public Optional<Livreur> getLivreurByTelephone(String telephone){
        return livreurDao.getLivreursByTelephone(telephone);
    }
    public List<Livreur> getLivreursByVehicule(String vehicule){
        return livreurDao.findAll().stream()
                .filter(livreur -> livreur.getVehicule().equalsIgnoreCase(vehicule))
                .collect(Collectors.toList());
    }

}
