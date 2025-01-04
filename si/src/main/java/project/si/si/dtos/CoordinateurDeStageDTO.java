package project.si.si.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CoordinateurDeStageDTO {
    private Long idCs;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String role;
    private EcoleDTO ecole;
}

