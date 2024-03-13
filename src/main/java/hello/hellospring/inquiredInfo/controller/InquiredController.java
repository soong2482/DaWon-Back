package hello.hellospring.inquiredInfo.controller;

import hello.hellospring.inquiredInfo.domain.Inquired;
import hello.hellospring.inquiredInfo.service.InquiredService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InquiredController {
    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
//    ${DaWonCar.backEndPoint}/

    private final InquiredService InquiredService;

    @PostMapping("${DaWonCar.backEndPoint}/Inquired/Inquire")
    @ResponseBody
    public String Inquired(@RequestBody Inquired inquired){
        return InquiredService.InsertInquired(inquired);
    }

    @GetMapping("${DaWonCar.backEndPoint}/Admin/Inquired/List")
    @ResponseBody
    public List<Inquired> InquiredList(){
        return InquiredService.getInquiredList();
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/DeleteInquired")
    @ResponseBody
    public String DeleteInquired(@RequestHeader("Inquired") Long id){
        return InquiredService.DeleteInquired(id);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/SuccessInquired")
    @ResponseBody
    public String SuccessInquired(@RequestHeader("Inquired") Long id){
        return InquiredService.SuccessInquired(id);
    }
}
