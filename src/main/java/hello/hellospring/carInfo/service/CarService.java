package hello.hellospring.carInfo.service;

import hello.hellospring.carInfo.domain.Insert.CarOption;
import hello.hellospring.carInfo.domain.Insert.CarTrim;
import hello.hellospring.carInfo.domain.Select.CarList;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    //Home화면 List CAR
    public List<CarList> getHomeList() {
        try {
            log.info("HomeList selected.");
            List<CarList> homeList = carMapper.HomeListCar();
            log.info("result size : {}", homeList.size());
            return homeList;
        } catch (Exception e) {
            log.error("Failed to get HomeList", e);
            return Collections.emptyList();
        }
    }

    public List<CarOption> getListCaroption(Long CarCode,String carTrimName){
        try {
            log.info("CarOption selected.");
            List<CarOption> carOptionList = carMapper.CarOption(CarCode,carTrimName);
            log.info("result size : {}",carOptionList.size());
            return carOptionList;
        } catch (Exception e) {
            log.error("Failed to get CarOptionList", e);
            return Collections.emptyList();
        }
    }

    public List<CarTrim> getListCarTrim(Long CarCode){
        try {
            log.info("CarTrim selected.");
            List<CarTrim> carTrimList = carMapper.CarTrim(CarCode);
            log.info("result size : {}",carTrimList.size());
            return  carTrimList;
        } catch (Exception e) {
            log.error("Failed to get CarTrimList", e);
            return Collections.emptyList();
        }
    }
    public List<CarList> getRecommendList(){
        try {
            log.info("RecommendList selected.");
            List<CarList> RecommendList = carMapper.RecommendListCar();
            log.info("result size : {}", RecommendList.size());
            return RecommendList;
        } catch (Exception e) {
            log.error("Failed to get RecommendList", e);
            return Collections.emptyList();
        }
    }
}
