package hello.hellospring.repository.customeruploadRepository;

import hello.hellospring.controller.UploadController.AlterForm;
import hello.hellospring.domain.CustomerUpload;

import java.util.List;

public interface CustomerUploadRepository {
    CustomerUpload save(CustomerUpload customerUpload);
    List<CustomerUpload> findAll();
    int countup();
    List<CustomerUpload> IndexfindAll();
    int update(AlterForm form);
    String remove(AlterForm form);

}