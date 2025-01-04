package project.si.si.mappers;

import org.mapstruct.Mapper;
import project.si.si.models.*;
import project.si.si.dtos.*;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    // Admin Mapping
    AdminDTO toDto(Admin admin);
    Admin toEntity(AdminDTO adminDTO);

    // Filiere Mapping
    FiliereDTO toDto(Filiere filiere);
    Filiere toEntity(FiliereDTO filiereDTO);

    // Ecole Mapping
    EcoleDTO toDto(Ecole ecole);
    Ecole toEntity(EcoleDTO ecoleDTO);

    // ChefDeFiliere Mapping
    ChefDeFiliereDTO toDto(ChefDeFiliere chefDeFiliere);
    ChefDeFiliere toEntity(ChefDeFiliereDTO chefDeFiliereDTO);

    // Etudiant Mapping
    EtudiantDTO toDto(Etudiant etudiant);
    Etudiant toEntity(EtudiantDTO etudiantDTO);

    // Stage Mapping
    StageDTO toDto(Stage stage);
    Stage toEntity(StageDTO stageDTO);

    // Offre Mapping
    OffreDTO toDto(Offre offre);
    Offre toEntity(OffreDTO offreDTO);

    // Postulation Mapping
    PostulationDTO toDto(Postulation postulation);
    Postulation toEntity(PostulationDTO postulationDTO);

    // RH Mapping
    RHDTO toDto(RH rh);
    RH toEntity(RHDTO rhDTO);

    // CoordinateurDeStage Mapping
    CoordinateurDeStageDTO toDto(CoordinateurDeStage coordinateurDeStage);
    CoordinateurDeStage toEntity(CoordinateurDeStageDTO coordinateurDeStageDTO);

    // Encadrant Mapping
    EncadrantDTO toDto(Encadrant encadrant);
    Encadrant toEntity(EncadrantDTO encadrantDTO);

    // Entreprise Mapping
    EntrepriseDTO toDto(Entreprise entreprise);
    Entreprise toEntity(EntrepriseDTO entrepriseDTO);

    // CompteEcole Mapping
    CompteEcoleDTO toDto(CompteEcole compteEcole);
    CompteEcole toEntity(CompteEcoleDTO compteEcoleDTO);

    // CompteEntreprise Mapping
    CompteEntrepriseDTO toDto(CompteEntreprise compteEntreprise);
    CompteEntreprise toEntity(CompteEntrepriseDTO compteEntrepriseDTO);

    // Entretien Mapping
    EntretienDTO toDto(Entretien entretien);
    Entretien toEntity(EntretienDTO entretienDTO);
}
