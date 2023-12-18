package hello.hellospring.service;

import hello.hellospring.controller.CarController.AlterCarForm;
import hello.hellospring.domain.Car;
import hello.hellospring.repository.CarRepository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long Save(Car car) {
        carRepository.save(car);
        return car.getId();
    }

    public Car changenumber(AlterCarForm alterform) {
        return carRepository.changenumber(alterform);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public String remove(AlterCarForm alterform) {
        return carRepository.remove(alterform);
    }

    public String updateprice(AlterCarForm alterform) {
        return carRepository.updateprice(alterform);
    }

    public int countup() {
        return carRepository.countup();
    }

    public List<Car> findIndexAll(){
        return carRepository.findIndexAll();
    }

}
