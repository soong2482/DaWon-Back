package hello.hellospring.repository.InquiredRepository;

import hello.hellospring.controller.InquiredController.InquiredAlterForm;
import hello.hellospring.domain.Inquired;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaInquiredRepository implements InquiredRepository{
    EntityManager em;

    public JpaInquiredRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Inquired save(Inquired inquired) {
        em.persist(inquired);
        return inquired;
    }

    @Override
    public List<Inquired> findAll() {
        return em.createQuery("select m from Inquired m", Inquired.class).getResultList();
    }


    @Override
    public int done(InquiredAlterForm alterForm) {
        return em.createQuery("update Inquired m set m.success = '완료' where m.id = :id")
                .setParameter("id", alterForm.getId()).executeUpdate();
    }

    @Override
    public String delete(InquiredAlterForm alterForm) {
        em.createQuery("delete from Inquired m where m.id= :id")
                .setParameter("id",alterForm.getId())
                .executeUpdate();
        em.createQuery("update Inquired m set m.id =m.id-1 where m.id > :id")
                .setParameter("id",alterForm.getId())
                .executeUpdate();
        return "delete complete";
    }
}
