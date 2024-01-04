package hello.hellospring.Controller;


import hello.hellospring.Domain.Car.Car;
import hello.hellospring.Domain.Car.CarList;
import hello.hellospring.Service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
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
