package com.ditraacademy.travelagency.core.chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambreController {
    @Autowired
    ChambreService chambreService;
    @GetMapping("/chambres")
    public ResponseEntity<?> getAllChambre ( ){
        return chambreService.getAllChambre ( );
    }

    @PostMapping("/chambre")
    public ResponseEntity <?> AddChambre(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
}}
