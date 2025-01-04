package project.si.si.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import project.si.si.dtos.EtudiantDTO;
import project.si.si.services.EtudiantService;

import java.util.List;


@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private  EtudiantService etudiantService;

    // Créer un étudiant
    @PostMapping
    public ResponseEntity<EtudiantDTO> createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        EtudiantDTO createdEtudiant = etudiantService.createEtudiant(etudiantDTO);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    // Récupérer un étudiant par ID
    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable Long id) {
        EtudiantDTO etudiantDTO = etudiantService.getEtudiantById(id);
        return new ResponseEntity<>(etudiantDTO, HttpStatus.OK);
    }

    // Récupérer les étudiants par école
    @GetMapping("/ecole/{ecoleId}")
    public ResponseEntity<List<EtudiantDTO>> getEtudiantsByEcole(@PathVariable Long ecoleId) {
        List<EtudiantDTO> etudiants = etudiantService.getEtudiantsByEcole(ecoleId);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    // Récupérer les étudiants par filière
    @GetMapping("/filiere/{filiereId}")
    public ResponseEntity<List<EtudiantDTO>> getEtudiantsByFiliere(@PathVariable Long filiereId) {
        List<EtudiantDTO> etudiants = etudiantService.getEtudiantsByFiliere(filiereId);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }
}


