package project.si.si.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.si.si.dtos.CompteEcoleDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.CompteEcole;
import project.si.si.models.Ecole;
import project.si.si.repositories.CompteEcoleRepository;
import project.si.si.repositories.EcoleRepository;
import project.si.si.services.CompteEcoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompteEcoleServiceImpl implements CompteEcoleService {
    private final CompteEcoleRepository compteRepository;
    private final EcoleRepository ecoleRepository;
    private final EntityMapper mapper;

    @Override
    public CompteEcoleDTO createCompteEcole(CompteEcoleDTO dto) {
        Ecole ecole = ecoleRepository.findById(dto.getEcoleId())
                .orElseThrow(() -> new RuntimeException("École introuvable"));

        CompteEcole compte = mapper.toEntity(dto);
        compte.setEcole(ecole);

        return mapper.toDto(compteRepository.save(compte));
    }

    @Override
    public CompteEcoleDTO updateCompteEcole(Long id, CompteEcoleDTO dto) {
        CompteEcole compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        Ecole ecole = ecoleRepository.findById(dto.getEcoleId())
                .orElseThrow(() -> new RuntimeException("École introuvable"));

        compte.setNom(dto.getNom());
        compte.setPrenom(dto.getPrenom());
        compte.setEmail(dto.getEmail());
        compte.setTelephone(dto.getTelephone());
        compte.setRole(dto.getRole());
        compte.setEcole(ecole);

        return mapper.toDto(compteRepository.save(compte));
    }

    @Override
    public CompteEcoleDTO getCompteEcoleById(Long id) {
        return compteRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @Override
    public List<CompteEcoleDTO> getAllComptesEcole() {
        return compteRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCompteEcole(Long id) {
        compteRepository.deleteById(id);
    }
}

