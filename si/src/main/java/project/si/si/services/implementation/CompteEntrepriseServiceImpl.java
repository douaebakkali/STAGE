package project.si.si.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.si.si.dtos.CompteEntrepriseDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.CompteEntreprise;
import project.si.si.models.Entreprise;
import project.si.si.repositories.CompteEntrepriseRepository;
import project.si.si.repositories.EntrepriseRepository;
import project.si.si.services.CompteEntrepriseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompteEntrepriseServiceImpl implements CompteEntrepriseService {
    private final CompteEntrepriseRepository compteRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final EntityMapper mapper;

    @Override
    public CompteEntrepriseDTO createCompteEntreprise(CompteEntrepriseDTO dto) {
        Entreprise entreprise = entrepriseRepository.findById(dto.getIdCompte())
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        CompteEntreprise compte = mapper.toEntity(dto);
        compte.setEntreprise(entreprise);

        return mapper.toDto(compteRepository.save(compte));
    }

    @Override
    public CompteEntrepriseDTO updateCompteEntreprise(Long id, CompteEntrepriseDTO dto) {
        CompteEntreprise compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        Entreprise entreprise = entrepriseRepository.findById(dto.getIdCompte())
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        compte.setNom(dto.getNom());
        compte.setPrenom(dto.getPrenom());
        compte.setEmail(dto.getEmail());
        compte.setTelephone(dto.getTelephone());
        compte.setEntreprise(entreprise);

        return mapper.toDto(compteRepository.save(compte));
    }

    @Override
    public CompteEntrepriseDTO getCompteEntrepriseById(Long id) {
        return compteRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @Override
    public List<CompteEntrepriseDTO> getAllComptesEntreprise() {
        return compteRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCompteEntreprise(Long id) {
        compteRepository.deleteById(id);
    }
}
