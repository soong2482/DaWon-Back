package hello.hellospring.repository.CarRepository;

import hello.hellospring.controller.CarController.AlterCarForm;
import hello.hellospring.domain.Car;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaCarRepository implements CarRepository {
    private final EntityManager em;

    public JpaCarRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Car> findAll() {
        return em.createQuery("select m from car m order by m.car_number asc", Car.class).getResultList();
    }

    @Override
    public Car save(Car car) {
        em.persist(car);
        return car;
    }

    @Override
    public Car changenumber(AlterCarForm alterform) {
        em.createQuery("update car m set m.car_number = :number where m.car_number=:changenum")
                .setParameter("number",alterform.getCar_number())
                .setParameter("changenum",alterform.getCar_changenumber())
                .executeUpdate();

        em.createQuery("update car m set m.car_number = :changenum where m.id=:id")
                .setParameter("changenum",alterform.getCar_changenumber())
                .setParameter("id",alterform.getId())
                .executeUpdate();
        return null;
    }

    @Override
    public int countup() {
        return em.createQuery("update car m set m.car_number = m.car_number+1").executeUpdate();
    }

    @Override
    public String remove(AlterCarForm alterform) {
        String jpql="delete from car m where m.id =:id";
        Query query = em.createQuery(jpql) .setParameter("id",alterform.getId());
        query.executeUpdate();
        em.createQuery("update car m set m.id = m.id-1 where m.id>:id")
                .setParameter("id",alterform.getId())
                .executeUpdate();
        em.createQuery("update car m set m.car_number = m.car_number-1 where m.car_number>:car_number")
                .setParameter("car_number",alterform.getCar_number())
                .executeUpdate();
        return "삭제완료";
    }

    @Override
    public String updateprice(AlterCarForm alterform) {
        em.createQuery("update car m set m.car_lease_price = :changeprice where m.id=:id")
                .setParameter("changeprice",alterform.getCar_changeprice())
                .setParameter("id",alterform.getId())
                .executeUpdate();

        return "수정완료";
    }

    @Override
    public List<Car> findIndexAll() {
        return em.createQuery("select m from car m where m.car_number <=17 order by m.car_number asc ", Car.class).getResultList();
    }


}
