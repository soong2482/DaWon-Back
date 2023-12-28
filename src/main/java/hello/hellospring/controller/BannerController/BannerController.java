package hello.hellospring.controller.BannerController;

import hello.hellospring.domain.AdminCenterBanner;
import hello.hellospring.domain.AdminHomeBanner;
import hello.hellospring.service.BannerService;
import hello.hellospring.service.CustomerUploadService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
 import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
 import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BannerController {
    private final BannerService bannerService;
    private final CustomerUploadService customerUploadService;
    private final HttpServletRequest request;
    private final SessionManager sessionManager;

    @Autowired
    public BannerController(BannerService bannerService, CustomerUploadService customerUploadService, HttpServletRequest request, SessionManager sessionManager) {
        this.bannerService = bannerService;
        this.customerUploadService = customerUploadService;
        this.request = request;
        this.sessionManager = sessionManager;
    }
    @GetMapping("imgslider")
    public String lis(Model model){
        List<AdminHomeBanner> admihomebanners = bannerService.findHome();
        model.addAttribute("mainbanner", admihomebanners);
        return "index/imgslider";
    }

    @GetMapping("/api/mainbanner")
    @ResponseBody
    public List<AdminHomeBanner> getMainBannerData() {
    return bannerService.findHome();
}


    @GetMapping("centerbanner")
    public String centerbanner(Model model){
        List<AdminCenterBanner> findIndexCenter = bannerService.findIndexCenter();
        model.addAttribute("centerbanners",findIndexCenter);
        return "index/centerbanner";
    }
    @GetMapping("adminbanner")
    public String list(Model model, Model model2) {
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            List<AdminHomeBanner> adminhomebanners = bannerService.findHome();
            List<AdminCenterBanner> admincenterbanners = bannerService.findCenter();
            model.addAttribute("adminhomebanners", adminhomebanners);
            model2.addAttribute("admincenterbanners", admincenterbanners);
            return "admin/adminbanner";
        }
    }
    @RequestMapping("centerbannerimg")
    public void getIMG(@RequestParam("name") String name,HttpServletResponse res) throws IOException {
        ServletOutputStream imgout = res.getOutputStream();

        String imgPath = genFileDirPath+"/img/Centerbanner/"+name+".png";
        String imgName = name;
        File f = new File(imgPath + File.separator + imgName);
        FileInputStream input = new FileInputStream(imgPath);
        int length;
        byte[] buffer = new byte[10];
        while ((length = input.read(buffer)) != -1)
            imgout.write(buffer,0,length);
    }
        @RequestMapping("homebannerimg")
    public void getIMGG(@RequestParam("name") String name,HttpServletResponse res) throws IOException {
        ServletOutputStream imgout = res.getOutputStream();

        String imgPath = genFileDirPath+"/img/Homebanner/"+name+".png";
        String imgName = name;
        File f = new File(imgPath + File.separator + imgName);
        FileInputStream input = new FileInputStream(imgPath);
        int length;
        byte[] buffer = new byte[10];
        while ((length = input.read(buffer)) != -1)
            imgout.write(buffer,0,length);
    }
    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;

    @PostMapping("adminhomebannerupload")
    public String upload(@RequestParam("img1") MultipartFile img1, HomeBannerForm form) {
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            try {
                AdminHomeBanner adminHomeBanner = new AdminHomeBanner();
                System.out.println(form.getHome_name());
                adminHomeBanner.setHome_name(form.getHome_name());
                img1.transferTo(new File(genFileDirPath + "/img/Homebanner/" + ((form.getHome_name() + ".png"))));
                adminHomeBanner.setHome_imgURL("/img/Homebanner/"+form.getHome_name() + ".png");
                adminHomeBanner.setNumber(0);
                bannerService.countup();
                bannerService.join(adminHomeBanner);
                return "admin/adminpage";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping("admincenterbannerupload")
    public String upload2(@RequestParam("img1") MultipartFile img1, CenterBannerForm form) {
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            try {
                AdminCenterBanner adminCenterBanner = new AdminCenterBanner();
                adminCenterBanner.setCenter_name(form.getCenter_name());
                img1.transferTo(new File(genFileDirPath + "/img/Centerbanner/" + ((form.getCenter_name() + ".png"))));
                adminCenterBanner.setCenter_imgURL("/img/Centerbanner/"+form.getCenter_name() + ".png");
                adminCenterBanner.setLook("false");
                bannerService.join(adminCenterBanner);
                return "admin/adminpage";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @PostMapping("changelook")
    public String changelook(AlterCenterBannerForm form){
        bannerService.changelook(form);
        return "admin/adminpage";
    }
    @PostMapping("removeadminhomebanner")
    public String remove(AlterHomeBannerForm form){
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            AdminHomeBanner adminHomeBanner = new AdminHomeBanner();
            adminHomeBanner.setId(form.getId());
            adminHomeBanner.setNumber(form.getNumber());
            bannerService.remove2(adminHomeBanner);
            return "admin/adminbanner";
        }
    }
    @PostMapping("removeadmincenterbanner")
    public String remove2(CenterBannerForm form){
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            AdminCenterBanner adminCenterBanner = new AdminCenterBanner();
            adminCenterBanner.setId(form.getId());
            bannerService.remove(adminCenterBanner);
            return "admin/adminbanner";
        }
    }
    @PostMapping("changeadminhomebanner")
    public String changenumber(AlterHomeBannerForm form){
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            AdminHomeBanner adminHomeBanner = new AdminHomeBanner();
            adminHomeBanner.setId(form.getId());
            adminHomeBanner.setNumber(form.getNumber());
            System.out.println(form.getNum());
            bannerService.changeNumber(adminHomeBanner,form.getNum());
            return "admin/adminbanner";
        }

    }
}
