package hello.hellospring.carInfo.service;

import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.mapper.CarMapper;
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
