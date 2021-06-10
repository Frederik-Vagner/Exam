package jpa.demo.repository;

import jpa.demo.model.Kommune;
import jpa.demo.model.Sogn;
import org.springframework.data.repository.CrudRepository;

public interface KommuneRepository extends CrudRepository<Kommune, Long> {
}
