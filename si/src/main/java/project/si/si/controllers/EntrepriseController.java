package project.si.si.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.si.si.dtos.EntrepriseDTO;
import project.si.si.services.EntrepriseService;

import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @PostMapping
    public EntrepriseDTO createEntreprise(@RequestBody EntrepriseDTO entrepriseDTO) {
        return entrepriseService.createEntreprise(entrepriseDTO);
    }

    @GetMapping("/{id}")
    public EntrepriseDTO getEntrepriseById(@PathVariable Long id) {
        return entrepriseService.getEntrepriseById(id);
    }

    @GetMapping
    public List<EntrepriseDTO> getAllEntreprises() {
        return entrepriseService.getAllEntreprises();
    }

    @PutMapping("/{id}")
    public EntrepriseDTO updateEntreprise(@PathVariable Long id, @RequestBody EntrepriseDTO entrepriseDTO) {
        return entrepriseService.updateEntreprise(id, entrepriseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEntreprise(@PathVariable Long id) {
        entrepriseService.deleteEntreprise(id);
    }
}

