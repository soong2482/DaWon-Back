package hello.hellospring.service;

import hello.hellospring.controller.UploadController.AlterForm;
import hello.hellospring.domain.CustomerUpload;
import hello.hellospring.repository.customeruploadRepository.CustomerUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class CustomerUploadService {

    private final CustomerUploadRepository customerUploadRepository;

    @Autowired
    public CustomerUploadService(CustomerUploadRepository customerUploadRepository){
        this.customerUploadRepository = customerUploadRepository;
    }
    public int join(CustomerUpload customerUpload){
        customerUploadRepository.save(customerUpload);
        return customerUpload.getId();
    }

    public List<CustomerUpload> IndexfindMembers(){return customerUploadRepository.IndexfindAll();}
    public List<CustomerUpload> findMembers(){
        return customerUploadRepository.findAll();
    }
    public int countup(){
        return customerUploadRepository.countup();
    }
    public int update(AlterForm form) {
        return customerUploadRepository.update(form);
    }
    public String remove(AlterForm form){
        return customerUploadRepository.remove(form);
    }
}
