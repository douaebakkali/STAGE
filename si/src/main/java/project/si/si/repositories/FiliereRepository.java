package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Filiere;

import java.util.Optional;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}

