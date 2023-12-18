package hello.hellospring.repository.AdminRepository;

import hello.hellospring.domain.Admin;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaAdminRepository implements  AdminRepository{
    private final EntityManager em;

    public JpaAdminRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<Admin> login(Admin admin) {
                List<Admin> result = em.createQuery(
                            "select a from Admin a where a.username=:username and a.password=:password", Admin.class)
                    .setParameter("username", admin.getUsername())
                    .setParameter("password", admin.getPassword())
                    .getResultList();
                    System.out.println(result.stream().findAny());
        return result.stream().findAny();
    }


}
