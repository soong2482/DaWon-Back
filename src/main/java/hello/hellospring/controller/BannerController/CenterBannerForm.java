package hello.hellospring.controller.BannerController;

import org.springframework.web.multipart.MultipartFile;

public class CenterBannerForm {
    private Long id;
    private String center_name;
    private MultipartFile img1;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }


    public MultipartFile getImg1() {
        return img1;
    }

    public void setImg1(MultipartFile img1) {
        this.img1 = img1;
    }


}
