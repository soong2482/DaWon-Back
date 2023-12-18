package hello.hellospring.service;

import hello.hellospring.controller.InquiredController.InquiredAlterForm;
import hello.hellospring.domain.Inquired;
import hello.hellospring.repository.InquiredRepository.InquiredRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class InquiredService {
    private final InquiredRepository inquiredRepository;

    @Autowired
    public InquiredService(InquiredRepository inquiredRepository) {
        this.inquiredRepository = inquiredRepository;
    }
    public String save(Inquired inquired){
        inquiredRepository.save(inquired);
        return inquired.getId();
    }
    public List<Inquired> findAll(){
        return inquiredRepository.findAll();
    }
    public int done(InquiredAlterForm form){ return inquiredRepository.done(form);}
    public String delete(InquiredAlterForm form){ return inquiredRepository.delete(form);}
}
