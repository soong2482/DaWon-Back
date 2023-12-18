package hello.hellospring.repository.BannerRepository;

import hello.hellospring.controller.BannerController.AlterCenterBannerForm;
import hello.hellospring.domain.AdminCenterBanner;
import hello.hellospring.domain.AdminHomeBanner;

import java.util.List;

public interface BannerRepository {
    List<AdminCenterBanner> findCenter();
    List<AdminHomeBanner> findHome();
    List<AdminCenterBanner> findIndexCenter();
    AdminCenterBanner save(AdminCenterBanner adminCenterBanner);
    AdminHomeBanner save(AdminHomeBanner adminHomeBanner);
    AdminHomeBanner changenumber(AdminHomeBanner adminHomeBanner,int num);
    String changelook(AlterCenterBannerForm alterCenterBannerForm);
    int countup();
    String remove(AdminCenterBanner adminCenterBanner);
    String remove2(AdminHomeBanner adminHomeBanner);
}
