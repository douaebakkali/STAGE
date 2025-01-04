package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Offre;
import project.si.si.models.RH;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findByRh(RH rh);

    List<Offre> findByEntrepriseIdEntreprise(Long entrepriseId);
}

