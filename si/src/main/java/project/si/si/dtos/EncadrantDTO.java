package project.si.si.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EncadrantDTO {
    private Long idEncadrant;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private EntrepriseDTO entreprise;
    private List<StageDTO> stages;
}
