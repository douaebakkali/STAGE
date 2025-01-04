package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}

