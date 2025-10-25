package io.github.Mahjoubech.smartlogi.controller;

import io.github.Mahjoubech.smartlogi.dto.ColisDto;
import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.service.ColisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c1/colis")
public class ColisController {
    private  final ColisService colisService;
    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }
    @PostMapping
    public ResponseEntity<Colis> enregistrerEtAssigner(@RequestBody ColisDto colisDto){
        Colis colisEnregistre= colisService.createColis(colisDto);
        return ResponseEntity.ok(colisEnregistre);
    }
}
