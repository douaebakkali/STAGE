package project.si.si.services;

import project.si.si.dtos.CompteEntrepriseDTO;
import java.util.List;

public interface CompteEntrepriseService {
    CompteEntrepriseDTO createCompteEntreprise(CompteEntrepriseDTO dto);
    CompteEntrepriseDTO updateCompteEntreprise(Long id, CompteEntrepriseDTO dto);
    CompteEntrepriseDTO getCompteEntrepriseById(Long id);
    List<CompteEntrepriseDTO> getAllComptesEntreprise();
    void deleteCompteEntreprise(Long id);
}
