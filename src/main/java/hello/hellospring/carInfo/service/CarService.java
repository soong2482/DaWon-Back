package hello.hellospring.carInfo.service;

import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    //Home화면 List CAR
    public List<CarList> getHomeList() {
        log.info("HomeList selected.");
        List<CarList> homeList = carMapper.HomeListCar();
        log.info("result size : {}", homeList.size());
        return homeList;
    }
}

