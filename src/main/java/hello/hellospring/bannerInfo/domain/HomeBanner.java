package hello.hellospring.bannerInfo.domain;

import lombok.Data;

@Data
public class HomeBanner {
    private Long homeBannerCode;
    private String homeBannerName;
    private String homeBannerImgURL;
    private Long homeBannerOrder;
}
