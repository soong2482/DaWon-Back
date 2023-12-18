package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
          return "index";
    }
    @GetMapping("header")
    public String header() {
        return "index/header";
    }
    @GetMapping("footer")
    public String footer(){
        return "index/footer";
    }
    @GetMapping("requestpage")
    public String requestpage(){
        return "index/request";
    }
    @GetMapping("request")
    public String request(@RequestParam("name") String name,@RequestParam("sort") String sort, Model model) {
        model.addAttribute("name",name);
        model.addAttribute("sort",sort);
        return "index/request";}
    @RequestMapping("adminpage")
    public ModelAndView index() throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/admin");
        return mav;
    }

}
