package hello.hellospring.controller.UploadController;

import hello.hellospring.domain.CustomerUpload;
import hello.hellospring.service.CustomerUploadService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;


@Controller

public class UploadController {
    private final CustomerUploadService customerUploadService;
    private final HttpServletRequest request;
    private final SessionManager sessionManager;
    @Autowired
    public UploadController(CustomerUploadService customerUploadService, HttpServletRequest request, SessionManager sessionManager) {
        this.customerUploadService = customerUploadService;
        this.request = request;
        this.sessionManager = sessionManager;
    }

    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;
    @GetMapping("admincustomer")
    public String customer(){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
        return "admin/admincustomer";
    }
    }
        @RequestMapping("uploadimg")
    public void getIMG(@RequestParam("name") String name,HttpServletResponse res) throws IOException {
        ServletOutputStream imgout = res.getOutputStream();

        String imgPath = genFileDirPath+"/img/customerreview/"+name+".png";
        String imgName = name;
        File f = new File(imgPath + File.separator + imgName);
        FileInputStream input = new FileInputStream(imgPath);
        int length;
        byte[] buffer = new byte[10];
        while ((length = input.read(buffer)) != -1)
            imgout.write(buffer,0,length);
    }
    @GetMapping("customerreview")
    public String list2(Model model){
        List<CustomerUpload> customerUploads = customerUploadService.IndexfindMembers();
        model.addAttribute("customeruploads",customerUploads);
        return "index/customerreview";
    }
    @PostMapping("upload")
    public String upload(@RequestParam("img1") MultipartFile img1,UploadForm form) {
        try {
            String cookie = (String) sessionManager.getSession(request);
            if(cookie.isEmpty()){
                return "/";
            }
            else {
                CustomerUpload customerUpload = new CustomerUpload();
                customerUpload.setBrand(form.getBrand());
                customerUpload.setTitle(form.getTitle());
                customerUpload.setPrice(form.getPrice());
                customerUpload.setTextarea(form.getTextarea());
                customerUpload.setCarsort(form.getCarsort());
                customerUpload.setSysdate(form.getSysdate());
                customerUpload.setDate(form.getDate());
                customerUpload.setNumber(0);
                img1.transferTo(new File(genFileDirPath + "/img/car/" +((form.getSysdate() + ".png"))));
                customerUpload.setImg1("/img/car/" +form.getSysdate() + ".png");
                customerUploadService.countup();
                customerUploadService.join(customerUpload);
                return "admin/adminpage";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("customermanage")
    public String list(Model model){
            String cookie = (String) sessionManager.getSession(request);
                if(cookie.isEmpty()){
                    return "/";
                }
                else {
                    List<CustomerUpload> customeruploads = customerUploadService.findMembers();
                    model.addAttribute("customeruploads", customeruploads);
                return "admin/admincustomermanage";
            }
    }

    @PostMapping("altercustomerupload")
    public String alter(AlterForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            customerUploadService.update(form);
            return "admin/admincustomermanage";
        }
    }
    @PostMapping("removecustomerupload")
    public String remove(AlterForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            customerUploadService.remove(form);
            return "admin/admincustomermanage";
        }
    }
}
