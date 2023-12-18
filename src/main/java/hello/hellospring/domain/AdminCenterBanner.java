package hello.hellospring.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "centerbanner")
public class AdminCenterBanner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String center_name;
    private String center_imgURL;
    private String look;

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getCenter_imgURL() {
        return center_imgURL;
    }

    public void setCenter_imgURL(String center_imgURL) {
        this.center_imgURL = center_imgURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }
}
