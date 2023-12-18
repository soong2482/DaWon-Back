package hello.hellospring.repository.fastinquiredrepository;


import hello.hellospring.controller.FastinquiredController.FastAlterForm;
import hello.hellospring.domain.Fastinquired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaFastinquiredRepository implements FastinquiredRepository{
    private final EntityManager em;

    public JpaFastinquiredRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Fastinquired save(Fastinquired fastinquired) {
        em.persist(fastinquired);
        return fastinquired;
    }

    @Override
    public Optional<Fastinquired> findById(Long id) {
        Fastinquired fastinquired = em.find(Fastinquired.class, id);
        return Optional.ofNullable(fastinquired);
    }

    @Override
    public Optional<Fastinquired> findByName(String name) {
        List<Fastinquired> result = em.createQuery("select m from Fastinquired m where m.name =:name", Fastinquired.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Fastinquired> findAll() {
        return em.createQuery("select m from Fastinquired m", Fastinquired.class)
                .getResultList();
    }

    @Override
    public int done(FastAlterForm form) {

        return em.createQuery("update Fastinquired m set m.success = '완료' where m.id = :id")
                .setParameter("id", form.getId()).executeUpdate();
    }

    @Override
    public String delete(FastAlterForm alterForm) {
        em.createQuery("delete from Fastinquired m where m.id =:id")
                .setParameter("id", alterForm.getId())
                .executeUpdate();
        em.createQuery("update Fastinquired m set m.id=m.id-1 where m.id > :id")
                .setParameter("id", alterForm.getId())
                .executeUpdate();
        return "success";
    }
}
