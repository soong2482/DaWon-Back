package hello.hellospring.carInfo.domain.Insert;


import lombok.Data;

@Data

public class MasterCar {
    private Long carCode;
    private String masterCarName;
    private String masterCarOrder;
    private boolean masterCarRecommend;
}
