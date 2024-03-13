package hello.hellospring.carInfo.domain.Select;

import lombok.Data;

@Data

public class CarList {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private String masterCarRecommend;
    //car_price
    private String carLeasePrice;
    private String carRentPrice;

    //car_img
    private String carImg;
    private String carBrandImg;
}