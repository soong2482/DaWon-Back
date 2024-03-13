package hello.hellospring.carInfo.controller;
import hello.hellospring.carInfo.domain.Insert.CarOption;
import hello.hellospring.carInfo.domain.Insert.CarTrim;
import hello.hellospring.carInfo.domain.Select.CarList;
import hello.hellospring.carInfo.mapper.CarMapper;
import hello.hellospring.carInfo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CarController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final CarMapper carMapper;
    private final CarService carService;

    @GetMapping("${DaWonCar.backEndPoint}/listCar")
    @ResponseBody
    public List<CarList> ListCar(){
        return carService.getHomeList();
    }

    @GetMapping("${DaWonCar.backEndPoint}/GetTrim")
    @ResponseBody
    public List<CarTrim> ListCarTrim(@RequestHeader("CarCode")  Long CarCode){ return carService.getListCarTrim(CarCode);}

    @GetMapping("${DaWonCar.backEndPoint}/GetOption")
    @ResponseBody
    public List<CarOption> ListCarOption(@RequestHeader("CarCode") Long CarCode ,@RequestHeader("CarTrimName")  String CarTrimName){
        return carService.getListCaroption(CarCode,CarTrimName);}


    @GetMapping("${DaWonCar.backEndPoint}/RecommendListCar")
    @ResponseBody
    public List<CarList> RecommendListCar(){ return carService.getRecommendList();}
}
