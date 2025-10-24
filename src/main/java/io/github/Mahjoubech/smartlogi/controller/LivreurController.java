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


}