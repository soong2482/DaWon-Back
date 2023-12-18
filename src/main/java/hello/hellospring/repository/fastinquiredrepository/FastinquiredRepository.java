package hello.hellospring.repository.fastinquiredrepository;

import hello.hellospring.controller.FastinquiredController.FastAlterForm;
import hello.hellospring.domain.Fastinquired;

import java.util.List;
import java.util.Optional;

public interface FastinquiredRepository {
      Fastinquired save(Fastinquired fastinquired);
      Optional<Fastinquired> findById(Long id);
      Optional<Fastinquired> findByName(String name);
      List<Fastinquired> findAll();
      int done(FastAlterForm alterForm);
      String delete(FastAlterForm alterForm);
}