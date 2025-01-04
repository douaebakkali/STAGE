package project.si.si.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.si.si.dtos.EtudiantDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.Ecole;
import project.si.si.models.Etudiant;
import project.si.si.models.Filiere;
import project.si.si.repositories.EcoleRepository;
import project.si.si.repositories.EtudiantRepository;
import project.si.si.repositories.FiliereRepository;
import project.si.si.services.EtudiantService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final EcoleRepository ecoleRepository;  // Repository pour l'école
    private final FiliereRepository filiereRepository;  // Repository pour la filière
    private final EntityMapper mapper;

    @Override
    public EtudiantDTO createEtudiant(EtudiantDTO dto) {
        // Vérification de l'existence de l'école et de la filière
        Ecole ecole = ecoleRepository.findById(dto.getEcoleId())
                .orElseThrow(() -> new RuntimeException("École introuvable"));
        Filiere filiere = filiereRepository.findById(dto.getFiliereId())
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));

        // Créer un étudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setEmail(dto.getEmail());
        etudiant.setTel(dto.getTel());
        etudiant.setPhotoProfil(dto.getPhotoProfil());
        etudiant.setPhotoCouverture(dto.getPhotoCouverture());
        etudiant.setEcole(ecole);  // Associer l'école
        etudiant.setFiliere(filiere);  // Associer la filière

        // Sauvegarder l'étudiant et le retourner
        return mapper.toDto(etudiantRepository.save(etudiant));
    }

    @Override
    public EtudiantDTO getEtudiantById(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
        return mapper.toDto(etudiant);
    }

    @Override
    public List<EtudiantDTO> getEtudiantsByEcole(Long ecoleId) {
        List<Etudiant> etudiants = etudiantRepository.findByEcoleIdEcole(ecoleId);
        return etudiants.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EtudiantDTO> getEtudiantsByFiliere(Long filiereId) {
        List<Etudiant> etudiants = etudiantRepository.findByFiliereIdFiliere(filiereId);
        return etudiants.stream().map(mapper::toDto).collect(Collectors.toList());
    }
}


