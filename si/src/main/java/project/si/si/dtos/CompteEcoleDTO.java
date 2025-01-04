package project.si.si.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CompteEcoleDTO {
    private Long idCompte;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String role;
    private Long ecoleId; // Reference to Ecole ID
}

