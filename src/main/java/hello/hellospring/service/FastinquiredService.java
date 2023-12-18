package hello.hellospring.service;

import hello.hellospring.controller.FastinquiredController.FastAlterForm;
import hello.hellospring.domain.Fastinquired;
import hello.hellospring.repository.fastinquiredrepository.FastinquiredRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class FastinquiredService {

    private final FastinquiredRepository fastinquiredRepository;

    @Autowired
    public FastinquiredService(FastinquiredRepository fastinquiredRepository) {
        this.fastinquiredRepository = fastinquiredRepository;
    }
    public String join(Fastinquired fastinquired){
        fastinquiredRepository.save(fastinquired);
        return fastinquired.getId();
    }
    public List<Fastinquired> findMembers(){
        return fastinquiredRepository.findAll();
    }
    public Optional<Fastinquired> findoOne(Long fastId){
        return fastinquiredRepository.findById(fastId);
    }
    public int done(FastAlterForm form){ return fastinquiredRepository.done(form);}
    public String delete(FastAlterForm form){
        return fastinquiredRepository.delete(form);
    }
}
