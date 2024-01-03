package hello.hellospring.Domain;


public class Car {

    private Long car_code;
    private String master_car_name;
    private Long master_car_code;

    //car_price
    private String car_lease_price;
    private String car_rent_price;

    //car_trim
    private String car_trim_name;

    //car_img
    private String car_img;
    private String car_brand_img;

    //car_option
    private String car_option;
    private String car_option_lease_price;



    //getter-setter
    public Long getCar_code() {
        return car_code;
    }

    public void setCar_code(Long car_code) {
        this.car_code = car_code;
    }

    public String getMaster_car_name() {
        return master_car_name;
    }

    public void setMaster_car_name(String master_car_name) {
        this.master_car_name = master_car_name;
    }

    public Long getMaster_car_code() {
        return master_car_code;
    }

    public void setMaster_car_code(Long master_car_code) {
        this.master_car_code = master_car_code;
    }

    public String getCar_lease_price() {
        return car_lease_price;
    }

    public void setCar_lease_price(String car_lease_price) {
        this.car_lease_price = car_lease_price;
    }

    public String getCar_rent_price() {
        return car_rent_price;
    }

    public void setCar_rent_price(String car_rent_price) {
        this.car_rent_price = car_rent_price;
    }

    public String getCar_trim_name() {
        return car_trim_name;
    }

    public void setCar_trim_name(String car_trim_name) {
        this.car_trim_name = car_trim_name;
    }

    public String getCar_img() {
        return car_img;
    }

    public void setCar_img(String car_img) {
        this.car_img = car_img;
    }

    public String getCar_brand_img() {
        return car_brand_img;
    }

    public void setCar_brand_img(String car_brand_img) {
        this.car_brand_img = car_brand_img;
    }

    public String getCar_option() {
        return car_option;
    }

    public void setCar_option(String car_option) {
        this.car_option = car_option;
    }

    public String getCar_option_lease_price() {
        return car_option_lease_price;
    }

    public void setCar_option_lease_price(String car_option_lease_price) {
        this.car_option_lease_price = car_option_lease_price;
    }
}
