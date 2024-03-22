package hello.hellospring.carInfo.domain.Insert;


import lombok.Data;

@Data

public class MasterCar {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private boolean masterCarRecommend;
    private String masterCarBrandName;
}
