package io.github.Mahjoubech.smartlogi.controller;

import io.github.Mahjoubech.smartlogi.service.ColisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c1/colis")
public class ColisController {
    private  final ColisService colisService;
    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }

}
