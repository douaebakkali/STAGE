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

public class EntrepriseDTO {
    private Long idEntreprise;
    private String nomEntreprise;
    private String description;
    private String villeEntreprise;
    private String adresseEntreprise;
    private String telephoneFix;
    private String domaineEntreprise;
    private List<Long> rhIds;
    private List<Long> encadrantIds;
    private List<Long> offreIds;
    private Long compteEntrepriseId;
}
