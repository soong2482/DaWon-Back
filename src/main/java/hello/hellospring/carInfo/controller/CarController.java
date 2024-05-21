package hello.hellospring.carInfo.controller;
import hello.hellospring.carInfo.domain.Insert.CarBrand;
import hello.hellospring.carInfo.domain.Insert.CarDetail;
import hello.hellospring.carInfo.domain.Insert.CarOption;
import hello.hellospring.carInfo.domain.Insert.CarTrim;
import hello.hellospring.carInfo.domain.Select.CarDetailList;
import hello.hellospring.carInfo.domain.Select.CarList;
import hello.hellospring.carInfo.domain.Select.CarRecommendList;
import hello.hellospring.carInfo.mapper.CarMapper;
import hello.hellospring.carInfo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @PostMapping("${DaWonCar.backEndPoint}/GetOption")
    @ResponseBody
    public List<CarOption> ListCarOption(@RequestBody Map<String, Object> requestBody) {
        Long carCode = Long.parseLong(String.valueOf(requestBody.get("CarCode")));
        String carTrimName = String.valueOf(requestBody.get("CarTrimName"));
        return carService.getListCaroption(carCode, carTrimName);
    }
    @GetMapping("${DaWonCar.backEndPoint}/CarDetailList")
    @ResponseBody
    public List<CarDetail> ListDetail(@RequestHeader("CarCode") Long CarCode) {
        return carService.DetailList(CarCode);
    }
    @GetMapping("${DaWonCar.backEndPoint}/RecommendListCar")
    @ResponseBody
    public List<CarRecommendList> RecommendListCar(){ return carService.getRecommendList();}

    @GetMapping("${DaWonCar.backEndPoint}/BrandList")
    @ResponseBody
    public List<CarBrand> BrandList(){ return carService.BrandList();}

    @GetMapping("${DaWonCar.backEndPoint}/DetailCar")
    @ResponseBody
    public List<CarDetailList> ListCarDetailList(@RequestHeader("CarCode") Long CarCode){
    return carService.CarDetailList(CarCode);
    }
}

