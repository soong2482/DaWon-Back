package hello.hellospring.carInfo.controller;


import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/listCar")
    @ResponseBody
    public List<CarList> ListCar(){
        return carService.getHomeList();
    }
}
