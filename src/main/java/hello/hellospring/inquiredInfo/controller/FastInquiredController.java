package hello.hellospring.inquiredInfo.controller;

import hello.hellospring.inquiredInfo.domain.FastInquired;
import hello.hellospring.inquiredInfo.service.FastInquiredService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FastInquiredController {
    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
//    ${DaWonCar.backEndPoint}
    private final FastInquiredService fastInquiredService;

    @PostMapping("${DaWonCar.backEndPoint}/FastInquired/Inquire")
    @ResponseBody
    public String FastInquired(@RequestBody FastInquired fastInquired){
        return fastInquiredService.InsertFastInquired(fastInquired);
    }

    @GetMapping("${DaWonCar.backEndPoint}/Admin/FastInquired/List")
    @ResponseBody
    public List<FastInquired> FastInquiredList(){
        return fastInquiredService.getFastInquiredList();
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/DeleteFastInquired")
    @ResponseBody
    public String DeleteFastInquired(@RequestHeader("FastInquired") Long id){
        return fastInquiredService.DeleteFastInquired(id);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/SuccessFastInquired")
    @ResponseBody
    public String SuccessFastInquired(@RequestHeader("FastInquired") Long id){
        return fastInquiredService.SuccessFastInquired(id);
    }
}