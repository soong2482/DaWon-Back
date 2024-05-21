package hello.hellospring.carInfo.domain.Select;


import lombok.Data;

@Data

public class CarRecommendList {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private boolean masterCarRecommend;
    private String masterCarBrandName;
    //car_price
    private String carLeasePrice;
    private String carRentPrice;
    //car_img
    private String carImg;
    //car_brand
    private String carBrandImg;
}
