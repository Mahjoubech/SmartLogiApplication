package io.github.Mahjoubech.smartlogi.controller;

import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
import io.github.Mahjoubech.smartlogi.entity.Livreur;
import io.github.Mahjoubech.smartlogi.service.LivreurService;
import io.github.Mahjoubech.smartlogi.exception.LivreurNotFoundException; // ✅ Import الاستثناء
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/livreurs")
public class LivreurController {

    private final LivreurService livreurService;

    public LivreurController(LivreurService livreurService) {
        this.livreurService = livreurService;
    }

    @PostMapping
    public ResponseEntity<Livreur> createLivreur(@RequestBody LivreurDto dto) {
        Livreur newLivreur = livreurService.createLivreur(dto);
        return new ResponseEntity<>(newLivreur, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livreur>> getAllLivreurs() {
        List<Livreur> livreurs = livreurService.getAllLivreurs();
        return ResponseEntity.ok(livreurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livreur> getLivreurById(@PathVariable Long id) {
        return livreurService.getLivreurById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    throw new LivreurNotFoundException("Livreur non trouvé avec ID: " + id);
                });
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable Long id, @RequestBody LivreurDto dto) {
        Livreur updatedLivreur = livreurService.updateLivreur(id, dto);
        return ResponseEntity.ok(updatedLivreur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivreur(@PathVariable Long id) {
        livreurService.deleteLivreur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(LivreurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(LivreurNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/telephone/{telephone}")
    public ResponseEntity<Livreur> getLivreurByTelephone(@PathVariable String telephone){
        try{
            Optional<Livreur> livreurOpt = livreurService.getLivreurByTelephone(telephone);
            if (livreurOpt.isPresent()) {
                return ResponseEntity.ok(livreurOpt.get());
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println("Error retrieving Livreur by telephone: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
    @GetMapping("/vehicule/{vehicule}")
    public ResponseEntity<List<Livreur>> getLivreursByVehicule(@PathVariable String vehicule){
        try{
            List<Livreur> livreurs = livreurService.getLivreursByVehicule(vehicule);
            return ResponseEntity.ok(livreurs);
        }catch (Exception e){
            System.out.println("Error retrieving Livreurs by vehicule: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}