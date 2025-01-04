package project.si.si.services;


import project.si.si.dtos.FiliereDTO;

import java.util.List;

public interface FiliereService {
    FiliereDTO createFiliere(FiliereDTO filiereDTO);
    FiliereDTO getFiliereById(Long id);
    List<FiliereDTO> getAllFilieres();
    FiliereDTO updateFiliere(Long id, FiliereDTO filiereDTO);
    void deleteFiliere(Long id);
}


