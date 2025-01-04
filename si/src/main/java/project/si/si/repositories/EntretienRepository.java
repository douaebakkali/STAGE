package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Entretien;

public interface EntretienRepository extends JpaRepository<Entretien, Long> {
}

