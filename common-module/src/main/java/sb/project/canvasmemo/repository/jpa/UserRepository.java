package sb.project.canvasmemo.repository.jpa;

import org.springframework.stereotype.Repository;
import sb.project.canvasmemo.entity.User;

@Repository
public interface UserRepository {
    public User findById(long id);
}
