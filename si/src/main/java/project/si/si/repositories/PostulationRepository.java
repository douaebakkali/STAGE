package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Etudiant;
import project.si.si.models.Offre;
import project.si.si.models.Postulation;

import java.util.List;

public interface PostulationRepository extends JpaRepository<Postulation, Long> {
    List<Postulation> findByOffre(Offre offre);
    List<Postulation> findByEtudiant(Etudiant etudiant);
}

