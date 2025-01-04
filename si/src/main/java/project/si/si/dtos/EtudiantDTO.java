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

public class EtudiantDTO {
    private Long idEtu;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String MotDePasse;
    private String codeEtu;
    private byte[] PhotoProfil;
    private byte[] PhotoCouverture;
    private String statutEtudiant;
    private Long ecoleId;
    private Long filiereId;
    private List<Long> postulationIds;
    private List<Long> entretienIds;
    private List<Long> stageIds;
}

