package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.CompteEcole;

public interface CompteEcoleRepository extends JpaRepository<CompteEcole, Long> {
    // Ajoutez des méthodes de recherche personnalisées si nécessaire
}

