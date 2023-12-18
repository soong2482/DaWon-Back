package hello.hellospring.repository.InquiredRepository;

import hello.hellospring.controller.InquiredController.InquiredAlterForm;
import hello.hellospring.domain.Inquired;

import java.util.List;

public interface InquiredRepository {
      Inquired save(Inquired inquired);
      List<Inquired> findAll();
      int done(InquiredAlterForm alterForm);
      String delete(InquiredAlterForm alterForm);

}