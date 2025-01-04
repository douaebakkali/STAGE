package project.si.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.si.si.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

