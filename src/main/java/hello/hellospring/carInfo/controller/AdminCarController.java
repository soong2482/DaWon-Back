package hello.hellospring.carInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.carInfo.domain.Insert.AddCar;
import hello.hellospring.carInfo.domain.Insert.CarDetail;
import hello.hellospring.carInfo.domain.Insert.CarOption;
import hello.hellospring.carInfo.domain.Insert.CarTrim;

import hello.hellospring.carInfo.service.AdminCarService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdminCarController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;

    private final AdminCarService admincarService;


    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertCar")
    @ResponseBody
    public String InsertCar(@RequestParam("Car_IMG") MultipartFile multipartFile ,@RequestParam("AddCar") String json){
        return admincarService.insertCar(multipartFile,json);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertTrim")
    @ResponseBody
    public String InsertTrim(@RequestBody Map<String, Object> requestPayload) {
        ObjectMapper objectMapper = new ObjectMapper();
        CarTrim carTrim = objectMapper.convertValue(requestPayload.get("carTrim"), CarTrim.class);
        String masterCarName = String.valueOf(requestPayload.get("masterCarName"));
        return admincarService.InsertTrim(carTrim, masterCarName);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/InsertBrand")
    @ResponseBody
    public String InsertBrand(@RequestParam("Car_Brand_IMG") MultipartFile multipartFile ,@RequestParam("Master_Car_Brand_Name") String masterCarBrandName) throws IOException {
        return admincarService.insertBrand(multipartFile,masterCarBrandName);
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
    public String CarTrimDelete(@RequestBody Map<String, Object> requestBody) {
        Long CarCode = Long.parseLong(String.valueOf(requestBody.get("CarCode")));
        String CarTrimName = String.valueOf(requestBody.get("CarTrimName"));
        return admincarService.CarTrimDelete(CarCode, CarTrimName);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/CarBrandDelete")
    @ResponseBody
    public String CarBrandDelete(@RequestBody String masterCarBrandName) {
        return admincarService.CarBrandDelete(masterCarBrandName);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/CarOptionDelete")
    @ResponseBody
    public String CarOptionDelete(@RequestBody Map<String, Object> requestBody){
        Long CarCode = Long.parseLong(String.valueOf(requestBody.get("CarCode")));
        String CarOption = String.valueOf(requestBody.get("CarOption"));
        return admincarService.CarOptionDelete(CarCode,CarOption);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/TrimPrice")
    @ResponseBody
    public String CarTrimPriceChange(@RequestBody Map<String, String> requestBody) {
        String trimName = requestBody.get("TrimName");
        String changeValueTrim = requestBody.get("ChangeValueTrim");
        return admincarService.CarTrimPriceChange(trimName, changeValueTrim);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/OptionPrice")
    @ResponseBody
    public String CarOptionPriceChange(@RequestBody Map<String, String> requestBody) {
        String OptionName = requestBody.get("OptionName");
        String ChangeValueOption = requestBody.get("ChangeValueOption");
        return admincarService.CarOptionPriceChange(OptionName, ChangeValueOption);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/CarLeasePrice")
    @ResponseBody
    public String CarLeasePriceChange(@RequestBody Map<String,String> requestBody){
        Long CarCode = Long.parseLong(String.valueOf(requestBody.get("CarCode")));
        String ChangeLeasePriceCar = requestBody.get("ChangeLeasePriceCar");
        return admincarService.CarLeasePriceChange(CarCode, ChangeLeasePriceCar);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/CarDetail")
    @ResponseBody
    public String CarDetailChange(@RequestBody CarDetail carDetail){
        return admincarService.CarDetailChange(carDetail);
    }
}
