package project.si.si.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EcoleDTO {
    private Long idEcole;
    private String nomEcole;
    private String villeEcole;
    private String adresseEcole;
    private String description;
    private String telephoneFix;
    private String typeEcole;
    private String domaineEcole;

    private CompteEcoleDTO compteEcole; // DTO for CompteEcole relation
    private List<EtudiantDTO> etudiants; // List of EtudiantDTOs
    private List<CoordinateurDeStageDTO> coordinateurs; // List of CoordinateurDeStageDTOs
    private List<ChefDeFiliereDTO> chefDeFilieres; // List of ChefDeFiliereDTOs
    private List<FiliereDTO> filieres; // List of FiliereDTOs for many-to-many
}
