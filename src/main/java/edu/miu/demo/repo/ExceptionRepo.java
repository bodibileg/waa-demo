package edu.miu.demo.repo;

import edu.miu.demo.domain.Exception;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<Exception,Long> {
}
