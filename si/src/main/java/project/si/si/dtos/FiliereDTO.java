package project.si.si.dtos;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FiliereDTO {
    private Long idFiliere; // Identifiant de la filière
    private String nomFiliere; // Nom de la filière
    private String abrvFiliere; // Abréviation de la filière

    // DTO du chef de filière (relation One-to-One)
    private ChefDeFiliereDTO chefDeFiliere;

    // Liste des étudiants (relation One-to-Many)
    private List<EtudiantDTO> etudiants;

    // Liste des écoles associées (relation Many-to-Many)
    private List<EcoleDTO> ecoles;
}
