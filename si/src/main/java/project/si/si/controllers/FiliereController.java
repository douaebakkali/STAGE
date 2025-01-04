package project.si.si.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.si.si.dtos.FiliereDTO;
import project.si.si.services.FiliereService;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Créer une nouvelle filière
    @PostMapping
    public ResponseEntity<FiliereDTO> createFiliere(@RequestBody FiliereDTO filiereDTO) {
        FiliereDTO createdFiliere = filiereService.createFiliere(filiereDTO);
        return new ResponseEntity<>(createdFiliere, HttpStatus.CREATED);
    }

    // Récupérer une filière par son ID
    @GetMapping("/{id}")
    public ResponseEntity<FiliereDTO> getFiliereById(@PathVariable Long id) {
        FiliereDTO filiere = filiereService.getFiliereById(id);
        return new ResponseEntity<>(filiere, HttpStatus.OK);
    }

    // Récupérer toutes les filières
    @GetMapping
    public ResponseEntity<List<FiliereDTO>> getAllFilieres() {
        List<FiliereDTO> filieres = filiereService.getAllFilieres();
        return new ResponseEntity<>(filieres, HttpStatus.OK);
    }

    // Mettre à jour une filière existante
    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> updateFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        FiliereDTO updatedFiliere = filiereService.updateFiliere(id, filiereDTO);
        return new ResponseEntity<>(updatedFiliere, HttpStatus.OK);
    }

    // Supprimer une filière par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

