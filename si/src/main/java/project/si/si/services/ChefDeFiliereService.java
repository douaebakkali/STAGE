package project.si.si.services;

import project.si.si.dtos.ChefDeFiliereDTO;
import java.util.List;

public interface ChefDeFiliereService {
    ChefDeFiliereDTO createChefDeFiliere(ChefDeFiliereDTO dto);
    ChefDeFiliereDTO updateChefDeFiliere(Long id, ChefDeFiliereDTO dto);
    ChefDeFiliereDTO getChefDeFiliereById(Long id);
    List<ChefDeFiliereDTO> getAllChefs();
    void deleteChefDeFiliere(Long id);
}

