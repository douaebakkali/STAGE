package project.si.si.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ChefDeFiliere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCf;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;

    @OneToOne
    private Filiere filiere;

    @ManyToOne
    private Ecole ecole;
}
