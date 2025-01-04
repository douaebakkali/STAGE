package project.si.si.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEcole;

    private String nomEcole;
    private String villeEcole;
    private String adresseEcole;
    private String description;
    private String telephoneFix;
    private String typeEcole;
    private String domaineEcole;

    @OneToOne(mappedBy = "ecole", cascade = CascadeType.ALL)
    private CompteEcole compteEcole; // Relation avec le compte utilisateur

    @OneToMany(mappedBy = "ecole")
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "ecole")
    private List<CoordinateurDeStage> coordinateurs;

    @OneToMany(mappedBy = "ecole")
    private List<ChefDeFiliere> chefDeFilieres;

    @ManyToMany
    @JoinTable(
            name = "ecole_filiere", // Nom de la table associative
            joinColumns = @JoinColumn(name = "ecole_id"), // Clé étrangère de Ecole
            inverseJoinColumns = @JoinColumn(name = "filiere_id") // Clé étrangère de Filiere
    )
    private List<Filiere> filieres;

}