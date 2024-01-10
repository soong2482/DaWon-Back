package hello.hellospring.carInfo.controller;


import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.service.CarService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/listCar")
    @ResponseBody
    public List<CarList> ListCar(){
        return carService.getHomeList();
    }
}
