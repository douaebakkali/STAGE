package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByEcoleIdEcole(Long ecoleId);

    List<Etudiant> findByFiliereIdFiliere(Long filiereId);
}

