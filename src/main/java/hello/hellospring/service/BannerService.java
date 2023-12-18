package hello.hellospring.service;

import hello.hellospring.controller.BannerController.AlterCenterBannerForm;
import hello.hellospring.domain.AdminCenterBanner;
import hello.hellospring.domain.AdminHomeBanner;
import hello.hellospring.repository.BannerRepository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BannerService {
    private final BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }
    public List<AdminCenterBanner> findCenter(){
        return bannerRepository.findCenter();
    }
    public List<AdminHomeBanner> findHome(){
        return bannerRepository.findHome();
    }
    public  List<AdminCenterBanner> findIndexCenter(){return bannerRepository.findIndexCenter();}
    public Long join(AdminHomeBanner adminHomeBanner){
        bannerRepository.save(adminHomeBanner);
        return adminHomeBanner.getId();
    }
    public Long join(AdminCenterBanner adminCenterBanner){
        bannerRepository.save(adminCenterBanner);
        return adminCenterBanner.getId();
    }
    public Long remove2(AdminHomeBanner adminHomeBanner){
        bannerRepository.remove2(adminHomeBanner);
        return adminHomeBanner.getId();
    }
    public Long changelook(AlterCenterBannerForm alterCenterBannerForm){
        bannerRepository.changelook(alterCenterBannerForm);
        return alterCenterBannerForm.getId();
    }
    public Long changeNumber(AdminHomeBanner adminHomebanner,int num){
        bannerRepository.changenumber(adminHomebanner,num);
        return  adminHomebanner.getId();
    }
    public Long remove(AdminCenterBanner adminCenterBanner){
        bannerRepository.remove(adminCenterBanner);
        return adminCenterBanner.getId();
    }
    public int countup(){
        return bannerRepository.countup();
    }
}
