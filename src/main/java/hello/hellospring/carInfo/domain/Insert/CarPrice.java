package hello.hellospring.carInfo.domain.Insert;


import lombok.Data;

@Data

public class CarPrice {
    private Long carCode;
    private String carLeasePrice;
    private String carRentPrice;
}
