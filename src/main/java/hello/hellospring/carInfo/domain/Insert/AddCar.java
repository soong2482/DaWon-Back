package hello.hellospring.carInfo.domain.Insert;


import lombok.Data;

@Data

public class AddCar {
    private String masterCarName;
    private String carLeasePrice;
    private String carRentPrice;
    private String carTrimName;
    private String carBrandName;

}