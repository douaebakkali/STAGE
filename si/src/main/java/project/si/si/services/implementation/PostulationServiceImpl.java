package project.si.si.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.si.si.dtos.PostulationDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.Etudiant;
import project.si.si.models.Offre;
import project.si.si.models.Postulation;
import project.si.si.repositories.EtudiantRepository;
import project.si.si.repositories.OffreRepository;
import project.si.si.repositories.PostulationRepository;
import project.si.si.services.PostulationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostulationServiceImpl implements PostulationService {
    private final PostulationRepository postulationRepository;
    private final OffreRepository offreRepository;
    private final EtudiantRepository etudiantRepository;
    private final EntityMapper mapper;

    @Override
    public PostulationDTO postuler(PostulationDTO dto) {
        Etudiant etudiant = etudiantRepository.findById(dto.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
        Offre offre = offreRepository.findById(dto.getOffreId())
                .orElseThrow(() -> new RuntimeException("Offre introuvable"));

        Postulation postulation = new Postulation();
        postulation.setEtudiant(etudiant);
        postulation.setOffre(offre);
        postulation.setCv(dto.getCv());
        postulation.setLettreMotivation(dto.getLettreMotivation());
        postulation.setEtatPostulation("En attente");

        // Sauvegarder la postulation
        return mapper.toDto(postulationRepository.save(postulation));
    }

    @Override
    public List<PostulationDTO> getAllPostulations() {
        return postulationRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostulationDTO> getPostulationsByOffreId(Long offreId) {
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre introuvable"));

        return postulationRepository.findByOffre(offre).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostulationDTO> getPostulationsByEtudiantId(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        return postulationRepository.findByEtudiant(etudiant).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateEtatPostulation(Long postulationId, String etat) {
        Postulation postulation = postulationRepository.findById(postulationId)
                .orElseThrow(() -> new RuntimeException("Postulation introuvable"));

        postulation.setEtatPostulation(etat);
        postulationRepository.save(postulation);
    }
}

