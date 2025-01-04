package project.si.si.services;

import project.si.si.dtos.CompteEcoleDTO;
import java.util.List;

public interface CompteEcoleService {
    CompteEcoleDTO createCompteEcole(CompteEcoleDTO dto);
    CompteEcoleDTO updateCompteEcole(Long id, CompteEcoleDTO dto);
    CompteEcoleDTO getCompteEcoleById(Long id);
    List<CompteEcoleDTO> getAllComptesEcole();
    void deleteCompteEcole(Long id);
}
