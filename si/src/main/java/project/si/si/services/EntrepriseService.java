package project.si.si.services;

import project.si.si.dtos.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDTO createEntreprise(EntrepriseDTO entrepriseDTO);

    EntrepriseDTO getEntrepriseById(Long id);

    List<EntrepriseDTO> getAllEntreprises();

    EntrepriseDTO updateEntreprise(Long id, EntrepriseDTO entrepriseDTO);

    void deleteEntreprise(Long id);
}
