package io.github.Mahjoubech.smartlogi.controller;

import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.enums.StatutColis;
import io.github.Mahjoubech.smartlogi.service.ColisService;
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
}
