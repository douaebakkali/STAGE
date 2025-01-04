package project.si.si.services;

import project.si.si.dtos.EcoleDTO;
import project.si.si.models.Filiere;

import java.util.List;

public interface EcoleService {
    EcoleDTO createEcole(EcoleDTO ecoleDTO);
    EcoleDTO updateEcole(Long id, EcoleDTO ecoleDTO);
    EcoleDTO getEcoleById(Long id);
    List<EcoleDTO> getAllEcoles();
    void deleteEcole(Long id);

    EcoleDTO addFiliereToEcole(Long ecoleId, Long filiereId);

    EcoleDTO removeFiliereFromEcole(Long ecoleId, Long filiereId);

    EcoleDTO updateFiliereInEcole(Long ecoleId, Long filiereId, Filiere newFiliere);
}




