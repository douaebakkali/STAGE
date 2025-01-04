package project.si.si.services;

import project.si.si.dtos.EtudiantDTO;

import java.util.List;

public interface EtudiantService {
    EtudiantDTO createEtudiant(EtudiantDTO dto);

    EtudiantDTO getEtudiantById(Long etudiantId);

    List<EtudiantDTO> getEtudiantsByEcole(Long ecoleId);

    List<EtudiantDTO> getEtudiantsByFiliere(Long filiereId);
}
