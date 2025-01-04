package project.si.si.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFiliere;

    private String nomFiliere;
    private String abrvFiliere;

    @OneToOne(mappedBy = "filiere")
    private ChefDeFiliere chefDeFiliere;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants; // Une filière peut avoir plusieurs étudiants

    @ManyToMany(mappedBy = "filieres")
    private List<Ecole> ecoles; // Liste des écoles associées

}
