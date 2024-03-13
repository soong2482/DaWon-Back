package hello.hellospring.inquiredInfo.service;
import hello.hellospring.inquiredInfo.domain.FastInquired;
import hello.hellospring.inquiredInfo.mapper.FastInquiredMapper;
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
public class FastInquiredService {

private final FastInquiredMapper fastInquiredMapper;

    @Async
    public String InsertFastInquired(FastInquired fastInquired){
        try {
            log.info("Insert FastInquired.");
            fastInquired.setCustomerFAuth(true);
            fastInquired.setCustomerFSuccess(false);
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            fastInquired.setCustomerFDate(currentTime.format(formatter));
            fastInquiredMapper.InsertFastInquired(fastInquired);
            log.info("Insert FastInquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert FastInquired: {}", e.getMessage());
            return "Failed";
        }
    }

    public List<FastInquired> getFastInquiredList(){
        try {
            log.info("FastInquired Selected.");
            List<FastInquired> fastInquireds = fastInquiredMapper.getFastInquiredList();
            log.info("result size : {}",fastInquireds.size());
            return fastInquireds;
        } catch (Exception e) {
            log.error("Failed to get FastInquired list: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public String DeleteFastInquired(Long id){
        try {
            log.info("Delete FastInquired.");
            fastInquiredMapper.DeleteFastInquired(id);
            log.info("Delete FastInquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete FastInquired: {}", e.getMessage());
            return "Failed";
        }
    }

    public String SuccessFastInquired(Long id){
        try {
            log.info("Update FastInquired.");
            fastInquiredMapper.SuccessFastInquired(id);
            log.info("Update FastInquired Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to update FastInquired: {}", e.getMessage());
            return "Failed";
        }
    }

}
