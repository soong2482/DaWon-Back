package hello.hellospring.bannerInfo.domain;

import lombok.Data;

@Data
public class CenterBanner {
    private Long centerBannerCode;
    private String centerBannerName;
    private String centerBannerImgURL;
    private boolean centerBannerLook;
}
