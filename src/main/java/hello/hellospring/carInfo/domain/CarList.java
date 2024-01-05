package hello.hellospring.carInfo.domain;

public class CarList {
    private Long CarCode;
    private String MasterCarName;
    private Long MasterCarOrder;
    private String MasterCarRecommend;
    //car_price
    private String CarLeasePrice;
    private String CarRentPrice;

    //car_img
    private String CarImg;
    private String CarBrandImg;


    public Long getCarCode() {
        return CarCode;
    }

    public void setCarCode(Long carCode) {
        CarCode = carCode;
    }

    public String getMasterCarName() {
        return MasterCarName;
    }

    public void setMasterCarName(String masterCarName) {
        MasterCarName = masterCarName;
    }

    public Long getMasterCarOrder() {
        return MasterCarOrder;
    }

    public void setMasterCarOrder(Long masterCarOrder) {
        MasterCarOrder = masterCarOrder;
    }

    public String getMasterCarRecommend() {
        return MasterCarRecommend;
    }

    public void setMasterCarRecommend(String masterCarRecommend) {
        MasterCarRecommend = masterCarRecommend;
    }

    public String getCarRentPrice() {
        return CarRentPrice;
    }

    public void setCarRentPrice(String carRentPrice) {
        CarRentPrice = carRentPrice;
    }

    public String getCarLeasePrice() {
        return CarLeasePrice;
    }

    public void setCarLeasePrice(String carLeasePrice) {
        CarLeasePrice = carLeasePrice;
    }

    public String getCarImg() {
        return CarImg;
    }

    public void setCarImg(String carImg) {
        CarImg = carImg;
    }

    public String getCarBrandImg() {
        return CarBrandImg;
    }

    public void setCarBrandImg(String carBrandImg) {
        CarBrandImg = carBrandImg;
    }
}