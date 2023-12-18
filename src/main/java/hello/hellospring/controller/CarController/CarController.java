package hello.hellospring.controller.CarController;

import hello.hellospring.domain.Car;
import hello.hellospring.service.CarService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CarController {
    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;

    private final CarService carService;
    private final SessionManager sessionManager;
    private final HttpServletRequest request;

    public CarController(CarService carService, SessionManager sessionManager, HttpServletRequest request) {
        this.carService = carService;
        this.sessionManager = sessionManager;
        this.request = request;
    }
    @GetMapping("admincar")
        public String List(Model model){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            List<Car> cars = carService.findAll();
            model.addAttribute("cars", cars);
            return "admin/admincar";
        }
        }
        @RequestMapping("carimg")
    public void getIMG(@RequestParam("name") String name,HttpServletResponse res) throws IOException {
        ServletOutputStream imgout = res.getOutputStream();

        String imgPath = genFileDirPath+"/img/car/"+name+".png";
        String imgName = name;
        File f = new File(imgPath + File.separator + imgName);
        FileInputStream input = new FileInputStream(imgPath);
        int length;
        byte[] buffer = new byte[10];
        while ((length = input.read(buffer)) != -1)
            imgout.write(buffer,0,length);
    }
    @GetMapping("indexcar")
    public String IndexListOne(Model model){
        List<Car> cars = carService.findIndexAll();
        model.addAttribute("cars",cars);
        return "index/carlist";
    }
    @GetMapping("requestpost")
    public String RequestPost(CarForm carForm,Model model){
        model.addAttribute("carsname",carForm);
        return "index/request";
    }

    @PostMapping("admincarupload")
    public String create(@RequestParam("img1") MultipartFile img1, CarForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            try {
                Car car = new Car();
                car.setCar_name(form.getCar_name());
                car.setCar_brand("/img/logo/"+form.getCar_brand()+".png");
                car.setCar_number(0);
                car.setCar_lease_price(form.getCar_lease_price());
                car.setCar_rent_price(form.getCar_rent_price());

                img1.transferTo(new File(genFileDirPath + "/img/car/" + ((form.getCar_name() + ".png"))));
                car.setCar_img("/img/car/" + form.getCar_name() + ".png");
                carService.countup();
                carService.Save(car);
                return "admin/adminpage";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @PostMapping("changenumbercar")
    public String changeNum(AlterCarForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            carService.changenumber(form);
            return "admin/adminpage";
        }
    }
    @PostMapping("removecar")
    public String remove(AlterCarForm form){
        String cookie = (String) sessionManager.getSession(request);
        System.out.println(form.getId());
        System.out.println(form.getCar_number());
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            carService.remove(form);
            return "admin/adminpage";
        }
    }
    @PostMapping("updatecarprice")
    public String changecarprice(AlterCarForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            carService.updateprice(form);
            return "admin/adminpage";
        }
    }
}
