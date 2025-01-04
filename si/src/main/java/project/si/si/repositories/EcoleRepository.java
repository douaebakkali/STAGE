package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Ecole;

public interface EcoleRepository extends JpaRepository<Ecole, Long> {
    // Ajoutez des méthodes de recherche personnalisées si nécessaire
}

