package hello.hellospring.Service;

import hello.hellospring.Domain.Car.CarList;
import hello.hellospring.Mapper.CarMapper;
import hello.hellospring.Domain.Car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    private final CarMapper carMapper;

    @Autowired
    public CarService(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    //Home화면 List CAR
    public List<CarList> getHomeList() {return carMapper.HomeListCar(); }
}
