package project.si.si.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.si.si.dtos.FiliereDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.Filiere;
import project.si.si.repositories.FiliereRepository;
import project.si.si.services.FiliereService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereServiceImpl implements FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public FiliereDTO createFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = entityMapper.toEntity(filiereDTO);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return entityMapper.toDto(savedFiliere);
    }

    @Override
    public FiliereDTO getFiliereById(Long id) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filiere not found with id: " + id));
        return entityMapper.toDto(filiere);
    }

    @Override
    public List<FiliereDTO> getAllFilieres() {
        return filiereRepository.findAll()
                .stream()
                .map(entityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FiliereDTO updateFiliere(Long id, FiliereDTO filiereDTO) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filiere not found with id: " + id));

        filiere.setNomFiliere(filiereDTO.getNomFiliere());
        filiere.setAbrvFiliere(filiereDTO.getAbrvFiliere());

        if (filiereDTO.getChefDeFiliere() != null) {
            filiere.setChefDeFiliere(entityMapper.toEntity(filiereDTO.getChefDeFiliere()));
        }

        if (filiereDTO.getEtudiants() != null) {
            filiere.setEtudiants(
                    filiereDTO.getEtudiants()
                            .stream()
                            .map(entityMapper::toEntity)
                            .collect(Collectors.toList())
            );
        }

        if (filiereDTO.getEcoles() != null) {
            filiere.setEcoles(
                    filiereDTO.getEcoles()
                            .stream()
                            .map(entityMapper::toEntity)
                            .collect(Collectors.toList())
            );
        }

        Filiere updatedFiliere = filiereRepository.save(filiere);
        return entityMapper.toDto(updatedFiliere);
    }

    @Override
    public void deleteFiliere(Long id) {
        if (!filiereRepository.existsById(id)) {
            throw new RuntimeException("Filiere not found with id: " + id);
        }
        filiereRepository.deleteById(id);
    }
}
