package hello.hellospring.inquiredInfo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Inquired {
    private  Long customerId;
    private String customerName;
    private String customerPhone;
    private String customerChoice;
    private String customerRegion;
    private String customerCarSort;
    private boolean customerAuth;
    private boolean customerSuccess;
    private String customerDate;
    private String customerText;
}
