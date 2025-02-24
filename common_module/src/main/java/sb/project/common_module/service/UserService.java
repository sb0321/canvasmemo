package sb.project.common_module.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.project.common_module.entity.User;
import sb.project.common_module.repository.jpa.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}
