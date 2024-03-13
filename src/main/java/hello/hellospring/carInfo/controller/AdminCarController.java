package hello.hellospring.carInfo.controller;

import hello.hellospring.carInfo.domain.Insert.AddCar;
import hello.hellospring.carInfo.domain.Insert.CarOption;
import hello.hellospring.carInfo.domain.Insert.CarTrim;

import hello.hellospring.carInfo.service.AdminCarService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class AdminCarController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final AdminCarService admincarService;


    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertCar")
    @ResponseBody
    public String InsertCar(@RequestParam("Car_IMG") MultipartFile multipartFile ,@RequestParam("AddCar") String json){
        return admincarService.insertCar(multipartFile,json);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertTrim")
    @ResponseBody
    public String InsertTrim(@RequestBody CarTrim carTrim) {
        return admincarService.InsertTrim(carTrim);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertOption")
    @ResponseBody
    public String InsertOption(@RequestBody CarOption carOption){
        return admincarService.InsertOption(carOption);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/UpdateCarOrder")
    @ResponseBody
    public String UpdateCarOrder(@RequestHeader("CarCode") Long CarCode,@RequestHeader("CarOrder")  String CarOrder,@RequestHeader("ChangeCarOrder") String ChangeCarOrder){
        return admincarService.UpdateCarOrder(CarCode,CarOrder,ChangeCarOrder);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/UpdateRecommendCar")
    @ResponseBody
    public String UpdateRecommendCar(@RequestHeader("CarCode")  Long CarCode){
        return admincarService.UpdateRecommendCar(CarCode);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/UpdateCarPrice")
    @ResponseBody
        public String UpdateCarPrice(@RequestHeader("CarCode") Long CarCode,@RequestHeader("CarPrice") String CarPrice){
        return admincarService.UpdateCarPrice(CarCode,CarPrice);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/CarDelete")
    @ResponseBody
    public String CarDelete(@RequestHeader("CarCode")  Long CarCode){
        return admincarService.CarDelete(CarCode);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/CarTrimDelete")
    @ResponseBody
    public String CarTrimDelete(@RequestHeader("CarCode") Long CarCode,@RequestHeader("CarTrimName")  String CarTrimName){
        return admincarService.CarTrimDelete(CarCode,CarTrimName);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/CarOptionDelete")
    @ResponseBody
    public String CarOptionDelete(@RequestHeader("CarCode") Long CarCode,@RequestHeader("CarOption")   String CarOption){
        return admincarService.CarOptionDelete(CarCode,CarOption);
    }



}
