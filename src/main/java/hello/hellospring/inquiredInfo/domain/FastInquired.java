package hello.hellospring.inquiredInfo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class FastInquired {
    private  Long customerFId;
    private String customerFName;
    private String customerFPhone;
    private String customerFBrand;
    private String customerFCarSort;
    private String customerFDate;
    private boolean customerFSuccess;
    private boolean customerFAuth;
}
