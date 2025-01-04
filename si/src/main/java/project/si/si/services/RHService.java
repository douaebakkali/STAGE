package project.si.si.services;

import project.si.si.dtos.RHDTO;
import project.si.si.models.RH;

import java.util.List;

public interface RHService {

    RHDTO createRH(RHDTO rhDTO);

    RHDTO getRHById(Long id);

    List<RHDTO> getAllRHs();

    RHDTO updateRH(Long id, RHDTO rhDTO);

    void deleteRH(Long id);

    List<RH> getRHByEntreprise(Long entrepriseId);
}
