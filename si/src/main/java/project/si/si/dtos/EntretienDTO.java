package project.si.si.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EntretienDTO {
    private Long idEntretien;
    private Date dateEntretien;
    private String adresse;
    private String duree;
    private String etat;
    private String resultat;
    private OffreDTO offre;
    private EtudiantDTO etudiant;
}

