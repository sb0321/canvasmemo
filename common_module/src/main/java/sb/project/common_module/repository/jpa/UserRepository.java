package sb.project.common_module.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sb.project.common_module.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
