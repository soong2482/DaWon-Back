package hello.hellospring.bannerInfo.controller;

import hello.hellospring.bannerInfo.domain.CenterBanner;
import hello.hellospring.bannerInfo.domain.ChangeOrder;
import hello.hellospring.bannerInfo.domain.HomeBanner;
import hello.hellospring.bannerInfo.service.CenterBannerService;
import hello.hellospring.bannerInfo.service.HomeBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AdminBannerController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final CenterBannerService adminCBS;
    private final HomeBannerService adminHBS;

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Insert/CenterBanner")
    @ResponseBody
    public String InsertCenterBanner(@RequestParam("Center_Banner_IMG") MultipartFile file, @RequestParam("Center_Banner_Name") String name) throws IOException {
        return adminCBS.InsertCenterBanner(file,name);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Insert/HomeBanner")
    @ResponseBody
    public String InsertHomeBanner(@RequestParam("Home_Banner_IMG") MultipartFile file, @RequestParam("Home_Banner_Name") String name) throws IOException {
        return adminHBS.InsertHomeBanner(file,name);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Delete/CenterBanner")
    @ResponseBody
    public String DeleteCenterBanner(@RequestHeader("CenterBannerCode") Long CenterBannerCode){
        return adminCBS.DeleteCenterBanner(CenterBannerCode);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Delete/HomeBanner")
    @ResponseBody
    public String DeleteHomeBanner(@RequestHeader("HomeBannerCode") Long HomeBannerCode){
        return adminHBS.DeleteHomeBanner(HomeBannerCode);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/CenterBanner")
    @ResponseBody
    public String ChangeCenterBannerOrder(@RequestHeader("CenterBannerCode") Long CenterBannerCode){
        return adminCBS.ChangeCenterBannerOrder(CenterBannerCode);
    }
    @PostMapping("${DaWonCar.backEndPoint}/Admin/Change/HomeBanner")
    @ResponseBody
    public String ChangeHomeBannerOrder(@RequestBody ChangeOrder changeOrder){
        return adminHBS.ChangeHomeBannerOrder(changeOrder);
    }

}
