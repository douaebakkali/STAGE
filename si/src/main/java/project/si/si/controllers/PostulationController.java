package project.si.si.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.si.si.dtos.OffreDTO;
import project.si.si.dtos.PostulationDTO;
import project.si.si.services.PostulationService;

import java.util.List;

@RestController
@RequestMapping("/api/postulations")
@RequiredArgsConstructor
public class PostulationController {
    private final PostulationService postulationService;

    @PostMapping("/postuler")
    public ResponseEntity<PostulationDTO> postuler(@RequestBody PostulationDTO dto) {
        PostulationDTO postulation = postulationService.postuler(dto);
        return new ResponseEntity<>(postulation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostulationDTO>> getAllPostulations() {
        List<PostulationDTO> postulations = postulationService.getAllPostulations();
        return new ResponseEntity<>(postulations, HttpStatus.OK);
    }

    @PatchMapping("/{postulationId}/etat")
    public ResponseEntity<Void> updateEtatPostulation(@PathVariable Long postulationId, @RequestParam String etat) {
        postulationService.updateEtatPostulation(postulationId, etat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/offre/{offreId}")
    public ResponseEntity<List<PostulationDTO>> getPostulationsByOffreId(@PathVariable Long offreId) {
        List<PostulationDTO> postulations = postulationService.getPostulationsByOffreId(offreId);
        return new ResponseEntity<>(postulations, HttpStatus.OK);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<PostulationDTO>> getPostulationsByEtudiantId(@PathVariable Long etudiantId) {
        List<PostulationDTO> postulations = postulationService.getPostulationsByEtudiantId(etudiantId);
        return new ResponseEntity<>(postulations, HttpStatus.OK);
    }
}
