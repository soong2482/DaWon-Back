package hello.hellospring.repository.CarRepository;

import hello.hellospring.controller.CarController.AlterCarForm;
import hello.hellospring.domain.Car;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    Car save(Car car);
    Car changenumber(AlterCarForm alterform);
    int countup();
    String remove(AlterCarForm alterform);
    String updateprice(AlterCarForm alterform);
    List<Car> findIndexAll();

}
