package hello.hellospring.domain;


import javax.persistence.*;

@Entity(name = "homebanner")
public class AdminHomeBanner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String home_name;
    private String home_imgURL;
    private int number;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getHome_imgURL() {
        return home_imgURL;
    }

    public void setHome_imgURL(String home_imgURL) {
        this.home_imgURL = home_imgURL;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
