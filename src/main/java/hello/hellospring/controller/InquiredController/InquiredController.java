package hello.hellospring.controller.InquiredController;

import hello.hellospring.domain.Inquired;
import hello.hellospring.service.InquiredService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InquiredController {
    private final InquiredService inquiredService;
    private final SessionManager sessionManager;
    private final HttpServletRequest request;
    @Autowired
    public InquiredController(InquiredService inquiredService, SessionManager sessionManager, HttpServletRequest request) {
        this.inquiredService = inquiredService;
        this.sessionManager = sessionManager;
        this.request = request;
    }

    @PostMapping("inquired/submit")
    public String submit(InquiredForm form){
        Inquired inquired = new Inquired();
        inquired.setName(form.getName());
        inquired.setCarsort(form.getCarsort());
        inquired.setDate(form.getDate());
        inquired.setChoice(form.getChoice());
        inquired.setPhone(form.getPhone());
        inquired.setRegion(form.getRegion());
        inquired.setSuccess("미완료");
        inquired.setText(form.getText());
        inquired.setAuth(form.getAuth());
        inquiredService.save(inquired);
        return "redirect:/";
    }
    @GetMapping("admininquired")
    public String list(Model model){

        String cookie = (String) sessionManager.getSession(request);
            if(cookie.isEmpty()){
                return "/";
            }
            else {
                List<Inquired> inquireds = inquiredService.findAll();
                model.addAttribute("inquireds", inquireds);
                return "admin/admininquired";
            }
    }
    @PostMapping("inquired/done")
    public String Done(InquiredAlterForm form) {
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            inquiredService.done(form);
            return "admin/admininquired";
        }
    }
    @PostMapping("inquired/delete")
    public String Delete(InquiredAlterForm form) {
        String cookie = (String) sessionManager.getSession(request);
        if (cookie.isEmpty()) {
            return "/";
        } else {
            inquiredService.delete(form);
            return "admin/admininquired";
        }
    }


}
