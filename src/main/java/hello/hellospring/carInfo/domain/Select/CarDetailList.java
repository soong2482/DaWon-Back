package hello.hellospring.carInfo.domain.Select;



import lombok.Data;

@Data

public class CarDetailList {
    //master_car
    private String masterCarName;
    //car_brand
    private String carBrandImg;
    //car_img
    private String carImg;
    //car_detail
    private String carRealPrice;
    private String carSort;
    private String carFuel;
    private String carMileage;
    private String car48Price;
    private String car24Price;
}
