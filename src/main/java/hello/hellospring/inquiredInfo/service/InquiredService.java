package hello.hellospring.inquiredInfo.service;

import hello.hellospring.inquiredInfo.domain.FastInquired;
import hello.hellospring.inquiredInfo.domain.Inquired;
import hello.hellospring.inquiredInfo.mapper.FastInquiredMapper;
import hello.hellospring.inquiredInfo.mapper.InquiredMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class InquiredService {

    private final InquiredMapper inquiredMapper;

    @Async
    public String InsertInquired(Inquired inquired){
        try {
            System.out.println(inquired.getCustomerChoice());
            log.info("Insert inquired.");
            inquired.setCustomerSuccess(false);
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            inquired.setCustomerDate(currentTime.format(formatter));
            inquiredMapper.InsertInquired(inquired);
            log.info("Insert Inquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Inquired: {}", e.getMessage());
            return "Failed";
        }
    }

    public List<Inquired> getInquiredList(){
        try {
            log.info("Inquired Selected.");
            List<Inquired> Inquireds = inquiredMapper.getInquiredList();
            log.info("result size : {}",Inquireds.size());
            return Inquireds;
        } catch (Exception e) {
            log.error("Failed to get Inquired list: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public String DeleteInquired(Long id){
        try {
            log.info("Delete Inquired.");
            inquiredMapper.DeleteInquired(id);
            log.info("Delete Inquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete Inquired: {}", e.getMessage());
            return "Failed";
        }
    }

    public String SuccessInquired(Long id){
        try {
            log.info("Update Inquired.");
            inquiredMapper.SuccessInquired(id);
            log.info("Update Inquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to update Inquired: {}", e.getMessage());
            return "Failed";
        }
    }

}
