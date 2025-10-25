package io.github.Mahjoubech.smartlogi.controller;

import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.enums.StatutColis;
import io.github.Mahjoubech.smartlogi.exception.ColisNotFondException;
import io.github.Mahjoubech.smartlogi.exception.LivreurNotFoundException;
import io.github.Mahjoubech.smartlogi.service.ColisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/c1/colis")
public class ColisController {
    private  final ColisService colisService;
    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }
    @PostMapping
    public ResponseEntity<Colis> enregistrerEtAssigner( @RequestBody ColisDto colisDto){
        Colis colisEnregistre= colisService.createColis( colisDto);
        return ResponseEntity.ok(colisEnregistre);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Colis> updateColis(@PathVariable Long id ,@RequestBody ColisDto colisDto){
        Colis colisUpdate= colisService.updateColis(id,colisDto);
        return ResponseEntity.ok(colisUpdate);
    }
    @PutMapping("/{id}/status?status={NEW_STATUS}")
    public ResponseEntity<Colis> updateColisStatus(@PathVariable Long id , @RequestParam StatutColis status) {
        Colis colisUpdateStatus = colisService.updateColisStatus(id, status);
        return ResponseEntity.ok(colisUpdateStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colis> getColisById(@PathVariable Long id) {
        Colis colis = colisService.getColisById(id).orElse(null);
        return ResponseEntity.ok(colis);
    }

    @GetMapping
    public ResponseEntity<Iterable<Colis>> getAllColis() {
        Iterable<Colis> colisList = colisService.getAllColis();
        return ResponseEntity.ok(colisList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColis(@PathVariable Long id) {
        colisService.deleteColis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/livreur/{livreurId}")
    public ResponseEntity<Iterable<Colis>> getColisByLivreurId(@PathVariable Long livreurId) {
       try{
           Iterable<Colis> colisList = colisService.getColisByLivreurId(livreurId);
           return ResponseEntity.ok(colisList);
       }catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @ExceptionHandler(ColisNotFondException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(ColisNotFondException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
