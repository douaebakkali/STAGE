package project.si.si.services;

import project.si.si.dtos.PostulationDTO;

import java.util.List;

public interface PostulationService {

    PostulationDTO postuler(PostulationDTO dto);

    List<PostulationDTO> getAllPostulations();

    List<PostulationDTO> getPostulationsByOffreId(Long offreId);

    List<PostulationDTO> getPostulationsByEtudiantId(Long etudiantId);

    void updateEtatPostulation(Long postulationId, String etat);
}
