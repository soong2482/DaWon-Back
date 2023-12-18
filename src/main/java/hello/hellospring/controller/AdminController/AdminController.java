package hello.hellospring.controller.AdminController;

import hello.hellospring.domain.Admin;
import hello.hellospring.service.AdminService;
import hello.hellospring.service.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
    private SessionManager sessionManager;
    private final AdminService adminService;
    private final HttpServletResponse response;
    @Autowired
        public AdminController(SessionManager sessionManager, AdminService adminService, HttpServletResponse response){
        this.sessionManager = sessionManager;
        this.adminService = adminService;
        this.response = response;
    }
    @PostMapping("adminlogin")
    public String login(AdminForm form){
        Admin admin = new Admin();
        String alert;
        admin.setUsername(form.getUsername());
        admin.setPassword(form.getPassword());
        
        if(adminService.login(admin).isEmpty()){
               alert="로그인실패";
                    return "redirect:/";
        }
        else{
            alert="로그인성공";
            sessionManager.createSession(form.getUsername(),response);
                 return "admin/adminpage";
        }
    }



}
