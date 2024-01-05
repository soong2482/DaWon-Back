package hello.hellospring.carInfo.service;

import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    //Home화면 List CAR
    public List<CarList> getHomeList() {return carMapper.HomeListCar(); }
}

