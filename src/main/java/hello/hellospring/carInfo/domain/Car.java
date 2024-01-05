package hello.hellospring.carInfo.domain;


public class Car {

    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;

    //car_price
    private String carLeasePrice;
    private String carRentPrice;

    //car_trim
    private String carTrimName;

    //car_img
    private String carImg;
    private String carBrandImg;

    //car_option
    private String carOption;
    private String carOptionLeasePrice;

    public Long getCarCode() {
        return carCode;
    }

    public void setCarCode(Long carCode) {
        this.carCode = carCode;
    }

    public String getMasterCarName() {
        return masterCarName;
    }

    public void setMasterCarName(String masterCarName) {
        this.masterCarName = masterCarName;
    }

    public Long getMasterCarOrder() {
        return masterCarOrder;
    }

    public void setMasterCarOrder(Long masterCarOrder) {
        this.masterCarOrder = masterCarOrder;
    }

    public String getCarLeasePrice() {
        return carLeasePrice;
    }

    public void setCarLeasePrice(String carLeasePrice) {
        this.carLeasePrice = carLeasePrice;
    }

    public String getCarRentPrice() {
        return carRentPrice;
    }

    public void setCarRentPrice(String carRentPrice) {
        this.carRentPrice = carRentPrice;
    }

    public String getCarTrimName() {
        return carTrimName;
    }

    public void setCarTrimName(String carTrimName) {
        this.carTrimName = carTrimName;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getCarBrandImg() {
        return carBrandImg;
    }

    public void setCarBrandImg(String carBrandImg) {
        this.carBrandImg = carBrandImg;
    }

    public String getCarOption() {
        return carOption;
    }

    public void setCarOption(String carOption) {
        this.carOption = carOption;
    }

    public String getCarOptionLeasePrice() {
        return carOptionLeasePrice;
    }

    public void setCarOptionLeasePrice(String carOptionLeasePrice) {
        this.carOptionLeasePrice = carOptionLeasePrice;
    }
}
