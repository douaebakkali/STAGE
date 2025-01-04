package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.CompteEntreprise;

public interface CompteEntrepriseRepository extends JpaRepository<CompteEntreprise, Long> {
    // Ajoutez des méthodes de recherche personnalisées si nécessaire
}

