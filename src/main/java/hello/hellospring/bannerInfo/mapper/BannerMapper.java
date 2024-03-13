package hello.hellospring.bannerInfo.mapper;

import hello.hellospring.bannerInfo.domain.CenterBanner;
import hello.hellospring.bannerInfo.domain.HomeBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    void InsertCenterBanner(CenterBanner centerBanner);
    void InsertHomeBanner(HomeBanner homeBanner);

    void DeleteCenterBanner(Long CenterBannerCode);
    void DeleteHomeBanner(Long HomeBannerCode);

    void UpdateCenterBanner();
    void UpdateCenterBannerLook(Long CenterBannerCode);
    void UpdateHomeBannerOrder(Long HomeBannerCode, Long ChangeHomeBannerCode);
    void UpdateDeleteHomeBanner(Long HomeBannerCode);
    Long getLastOrder();

    List<CenterBanner> CenterBannerHome();
    List<CenterBanner> CenterBanner();
    List<HomeBanner> HomeBanner();
}