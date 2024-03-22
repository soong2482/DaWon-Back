package hello.hellospring.carInfo.domain;

import lombok.Data;

@Data
public class Car {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private String masterCarBrandName;

    //car_price
    private String carLeasePrice;
    private String carRentPrice;

    //car_trim
    private String carTrimName;

    //car_img
    private String carImg;

    //car_option
    private String carOption;
    private String carOptionLeasePrice;
}
