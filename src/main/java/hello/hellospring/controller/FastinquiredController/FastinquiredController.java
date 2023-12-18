package hello.hellospring.controller.FastinquiredController;

import hello.hellospring.domain.Fastinquired;
import hello.hellospring.service.FastinquiredService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class FastinquiredController {
    private final FastinquiredService fastinquiredService;
    private final SessionManager sessionManager;
    private final HttpServletRequest request;

@Autowired    
    public FastinquiredController(FastinquiredService fastinquiredService, SessionManager sessionManager, HttpServletRequest request){
        this.fastinquiredService = fastinquiredService;

    this.sessionManager = sessionManager;
    this.request = request;
}
    @PostMapping("fastinquired/inquire")
    public String create(FastinquiredForm form) {
        Fastinquired fastinquired = new Fastinquired();
        fastinquired.setName(form.getName());
        fastinquired.setBrand(form.getBrand());
        fastinquired.setCarsort(form.getCarsort());
        String Phone =form.getPhone()+form.getPhone1()+form.getPhone2();
        fastinquired.setPhone(Phone);
        fastinquired.setAuth("동의");
        fastinquired.setSuccess("미완료");
        fastinquired.setDate(form.getDate());
            fastinquiredService.join(fastinquired);
            return "redirect:/";
    }

    @GetMapping("adminfastinquired")
    public String list(Model model){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            List<Fastinquired> fastinquireds = fastinquiredService.findMembers();
            model.addAttribute("fastinquireds", fastinquireds);
            return "admin/adminfastinquired";
        }
    }
    @PostMapping("fastinquired/done")
    public String Done(FastAlterForm form){
        String cookie = (String) sessionManager.getSession(request);
        if(cookie.isEmpty()){
            return "/";
        }
        else {
            fastinquiredService.done(form);
            return "admin/adminpage";
        }
    }

    @PostMapping("fastinquired/delete")
    public String Delete(FastAlterForm form) {
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            fastinquiredService.delete(form);
            return "admin/adminpage";
        }

    }
}
