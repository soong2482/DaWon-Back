package hello.hellospring.carInfo.domain;

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

    public String getMasterCarRecommend() {
        return masterCarRecommend;
    }

    public void setMasterCarRecommend(String masterCarRecommend) {
        this.masterCarRecommend = masterCarRecommend;
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
}