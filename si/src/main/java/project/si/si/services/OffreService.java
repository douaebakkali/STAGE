package project.si.si.services;

import project.si.si.dtos.OffreDTO;
import project.si.si.models.Offre;

import java.util.List;

public interface OffreService {
    OffreDTO createOffre(OffreDTO dto);

    List<OffreDTO> getAllOffres();

    OffreDTO updateOffre(Long offreId, OffreDTO offreDTO);

    List<OffreDTO> getOffresByRH(Long rhId);

    List<Offre> getOffresByEntreprise(Long entrepriseId);
}
