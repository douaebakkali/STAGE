package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {
}

