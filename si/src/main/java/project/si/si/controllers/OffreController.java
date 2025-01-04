package project.si.si.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import project.si.si.dtos.OffreDTO;
import project.si.si.models.Offre;
import project.si.si.services.OffreService;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
@RequiredArgsConstructor
public class OffreController {
    private final OffreService offreService;

    @PostMapping
    public ResponseEntity<OffreDTO> createOffre(@RequestBody OffreDTO offreDTO) {
        OffreDTO createdOffre = offreService.createOffre(offreDTO);
        return new ResponseEntity<>(createdOffre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OffreDTO>> getAllOffres() {
        List<OffreDTO> offres = offreService.getAllOffres();
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @PutMapping("/{offreId}")
    public ResponseEntity<OffreDTO> updateOffre(@PathVariable Long offreId, @RequestBody OffreDTO offreDTO) {
        OffreDTO updatedOffre = offreService.updateOffre(offreId, offreDTO);
        return new ResponseEntity<>(updatedOffre, HttpStatus.OK);
    }
    // Récupérer les offres associées à un responsable RH
    @GetMapping("/rh/{rhId}")
    public ResponseEntity<List<OffreDTO>> getOffresByRH(@PathVariable Long rhId) {
        List<OffreDTO> offres = offreService.getOffresByRH(rhId);
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/entreprise/{entrepriseId}")
    public List<Offre> getOffresByEntreprise(@PathVariable Long entrepriseId) {
        return offreService.getOffresByEntreprise(entrepriseId);
    }

}

