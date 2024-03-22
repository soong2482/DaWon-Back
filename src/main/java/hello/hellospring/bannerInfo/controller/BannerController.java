package hello.hellospring.bannerInfo.controller;

import hello.hellospring.bannerInfo.domain.CenterBanner;
import hello.hellospring.bannerInfo.domain.HomeBanner;
import hello.hellospring.bannerInfo.service.CenterBannerService;
import hello.hellospring.bannerInfo.service.HomeBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BannerController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final CenterBannerService centerBannerService;
    private final HomeBannerService homeBannerService;

    @GetMapping("${DaWonCar.backEndPoint}/CenterBannerList")
    @ResponseBody
    public List<CenterBanner> ListCenterBanner() {return centerBannerService.CenterBannerList();}

    @GetMapping("${DaWonCar.backEndPoint}/HomeBannerList")
    @ResponseBody
    public List<HomeBanner> ListHomeBanner() {return homeBannerService.HomeBannerList();}

    @GetMapping("${DaWonCar.backEndPoint}/CenterBanner")
    @ResponseBody
    public List<CenterBanner> CenterBanner() {return centerBannerService.CenterBanner();}

}
