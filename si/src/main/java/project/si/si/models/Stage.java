package project.si.si.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStage;
    private String titre;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String duree;
    private String localisation;
    private Float montantRemuneration;
    private String statut;
    private String type;


    @ManyToOne
    @JoinColumn(name = "etudiant_id") // Clé étrangère dans la table Stage
    private Etudiant etudiant; // Chaque stage est lié à un étudiant

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    @ManyToOne
    @JoinColumn(name ="encadrant_id")
    private Encadrant encadrant;
}
