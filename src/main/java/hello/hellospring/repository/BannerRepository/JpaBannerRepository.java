package hello.hellospring.repository.BannerRepository;

import hello.hellospring.controller.BannerController.AlterCenterBannerForm;
import hello.hellospring.domain.AdminCenterBanner;
import hello.hellospring.domain.AdminHomeBanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaBannerRepository implements BannerRepository{
    private final EntityManager em;

    public JpaBannerRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public List<AdminCenterBanner> findCenter() {
        return em.createQuery("select m from centerbanner m", AdminCenterBanner.class).getResultList();
    }
    @Override
    public List<AdminCenterBanner> findIndexCenter() {
        return em.createQuery("select m from centerbanner m where m.look =:look", AdminCenterBanner.class)
                .setParameter("look","true").getResultList();
    }

    @Override
    public List<AdminHomeBanner> findHome() {
        return em.createQuery("select m from homebanner m order by m.number asc",
                AdminHomeBanner.class).getResultList();
    }

    @Override
    public AdminCenterBanner save(AdminCenterBanner adminCenterBanner) {
        em.persist(adminCenterBanner);
        return adminCenterBanner;
    }

    @Override
    public AdminHomeBanner save(AdminHomeBanner adminHomeBanner) {
        em.persist(adminHomeBanner);
        return adminHomeBanner;
    }

    @Override
    public AdminHomeBanner changenumber(AdminHomeBanner adminHomeBanner,int num) {
        em.createQuery("update homebanner m set m.number = :number where m.number=:num")
                .setParameter("number",adminHomeBanner.getNumber())
                .setParameter("num",num)
                .executeUpdate();

        em.createQuery("update homebanner m set m.number = :num where m.id=:id")
                .setParameter("num",num)
                .setParameter("id",adminHomeBanner.getId())
                .executeUpdate();
        return null;
    }

    @Override
    public String changelook(AlterCenterBannerForm alterCenterBannerForm) {
        em.createQuery("update centerbanner m set m.look = :look where m.look=:loook")
                .setParameter("look","false")
                .setParameter("loook","true")
                .executeUpdate();

        em.createQuery("update centerbanner m set m.look = :look where m.id=:id")
                .setParameter("look","true")
                .setParameter("id",alterCenterBannerForm.getId())
                .executeUpdate();
        return null;
    }

    @Override
    public int countup() {
        return em.createQuery("update homebanner m set m.number = m.number+1").executeUpdate();
    }

    @Override
    public String remove(AdminCenterBanner adminCenterBanner) {
        String jpql="delete from centerbanner m where m.id =:id";
        Query query = em.createQuery(jpql) .setParameter("id",adminCenterBanner.getId());
        query.executeUpdate();
        em.createQuery("update centerbanner m set m.id = m.id-1 where m.id>:id")
                .setParameter("id",adminCenterBanner.getId())
                .executeUpdate();
        return "삭제완료";
    }

    @Override
    public String remove2(AdminHomeBanner adminHomeBanner) {
        String jpql="delete from homebanner m where m.id =:id";
        Query query = em.createQuery(jpql) .setParameter("id",adminHomeBanner.getId());
        query.executeUpdate();
        em.createQuery("update homebanner m set m.id = m.id-1 where m.id>:id")
                .setParameter("id",adminHomeBanner.getId())
                .executeUpdate();
        em.createQuery("update homebanner m set m.number = m.number-1 where m.number>:number")
                .setParameter("number",adminHomeBanner.getNumber())
                .executeUpdate();
        return "삭제완료";
    }


}
