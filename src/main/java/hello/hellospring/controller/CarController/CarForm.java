package hello.hellospring.controller.CarController;

public class CarForm {
    private String car_name;
    private String car_brand;
    private String car_lease_price;
    private String car_rent_price;
    private String car_img;

    public String getCar_rent_price() {
        return car_rent_price;
    }

    public void setCar_rent_price(String car_rent_price) {
        this.car_rent_price = car_rent_price;
    }

    public String getCar_lease_price() {
        return car_lease_price;
    }

    public void setCar_lease_price(String car_lease_price) {
        this.car_lease_price = car_lease_price;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_img() {
        return car_img;
    }

    public void setCar_img(String car_img) {
        this.car_img = car_img;
    }
}
