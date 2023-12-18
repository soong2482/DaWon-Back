package hello.hellospring.repository.AdminRepository;

import hello.hellospring.domain.Admin;

import java.util.Optional;

public interface AdminRepository {
   Optional<Admin> login (Admin admin);

}