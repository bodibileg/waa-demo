package edu.miu.demo.repo;

import edu.miu.demo.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Integer> {
}
