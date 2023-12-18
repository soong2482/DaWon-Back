package hello.hellospring.repository.customeruploadRepository;

import hello.hellospring.controller.UploadController.AlterForm;
import hello.hellospring.domain.CustomerUpload;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaCustomeruploadRepository implements CustomerUploadRepository {
    private final EntityManager em;

    public JpaCustomeruploadRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public CustomerUpload save(CustomerUpload customerupload) {
        em.persist(customerupload);
        return customerupload;
    }

    @Override
    public List<CustomerUpload> findAll() {
        return em.createQuery("select m from CustomerUpload m order by m.number asc", CustomerUpload.class).getResultList();
    }

    @Override
    public int countup() {
        //update customer_upload set number = number+1;
        return em.createQuery("update CustomerUpload m set m.number = m.number+1").executeUpdate();

    }

    @Override
    public List<CustomerUpload> IndexfindAll(){
        return em.createQuery("select m from CustomerUpload m where m.number <=4 order by m.number asc",CustomerUpload.class).getResultList();
    }

    @Override
    public int update(AlterForm form) {
        em.createQuery("update CustomerUpload m set m.number = :number where m.number=:num")
                .setParameter("number",form.getNumber())
                .setParameter("num",form.getNum())
                .executeUpdate();

        em.createQuery("update CustomerUpload m set m.number = :num where m.id=:id")
                .setParameter("num",form.getNum())
                .setParameter("id",form.getId())
                .executeUpdate();
        return 1;
    }

    @Override
    public String remove(AlterForm form) {
        String jpql = "delete from CustomerUpload m where m.id =:id";
        Query query = em.createQuery(jpql).setParameter("id", form.getId());
        query.executeUpdate();
        em.createQuery("update CustomerUpload m set m.id=m.id-1 where m.id > :id")
                .setParameter("id",form.getId()).executeUpdate();
        em.createQuery("update CustomerUpload m set m.number = m.number-1 where m.number > :number")
                .setParameter("number",form.getNumber()).executeUpdate();
        return "삭제완료";
    }
}
