package hello.hellospring.bannerInfo.domain;

import lombok.Data;


@Data
public class ChangeOrder {
    private Long homeBannerCode;
    private Long homeBannerOrder;
    private Long changeHomeBannerCode;
    private Long changeHomeBannerOrder;
}
