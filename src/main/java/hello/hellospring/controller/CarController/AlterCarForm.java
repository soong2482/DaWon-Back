package hello.hellospring.controller.CarController;

public class AlterCarForm {
    private Long id;
    private int car_number;
    private int car_changenumber;
    private String car_changeprice;



    public int getCar_number() {
        return car_number;
    }

    public void setCar_number(int car_number) {
        this.car_number = car_number;
    }

    public int getCar_changenumber() {
        return car_changenumber;
    }

    public void setCar_changenumber(int car_changenumber) {
        this.car_changenumber = car_changenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCar_changeprice() {
        return car_changeprice;
    }

    public void setCar_changeprice(String car_changeprice) {
        this.car_changeprice = car_changeprice;
    }
}
