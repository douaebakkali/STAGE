package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.RH;

import java.util.List;

public interface RHRepository extends JpaRepository<RH, Long> {
    List<RH> findByEntrepriseIdEntreprise(Long entrepriseId);
}
