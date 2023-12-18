package hello.hellospring.service;

import hello.hellospring.domain.Admin;
import hello.hellospring.repository.AdminRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Optional<Admin> login(Admin admin){
        return adminRepository.login(admin);
    }


}
