package project.si.si.services.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.si.si.dtos.AdminDTO;
import project.si.si.mappers.EntityMapper;
import project.si.si.models.Admin;
import project.si.si.repositories.AdminRepository;
import project.si.si.services.AdminService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  AdminRepository adminRepository;

    @Autowired
    private  EntityMapper entityMapper;


    @Override
    public AdminDTO save(AdminDTO adminDTO) {
        Admin admin = entityMapper.toEntity(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return entityMapper.toDto(savedAdmin);
    }


    @Override
    public Optional<AdminDTO> findById(Long id) {
        return adminRepository.findById(id)
                .map(entityMapper::toDto);
    }

    @Override
    public List<AdminDTO> findAll() {
        return adminRepository.findAll().stream()
                .map(entityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }



}
