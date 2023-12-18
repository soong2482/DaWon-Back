package hello.hellospring.controller.BannerController;

import org.springframework.web.multipart.MultipartFile;

public class HomeBannerForm {
    private Long id;
    private String home_name;
    private MultipartFile img1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public MultipartFile getImg1() {
        return img1;
    }

    public void setImg1(MultipartFile img1) {
        this.img1 = img1;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }
}
