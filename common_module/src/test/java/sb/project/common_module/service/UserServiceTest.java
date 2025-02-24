package sb.project.common_module.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sb.project.common_module.entity.User;
import sb.project.common_module.repository.jpa.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    AutoCloseable closeable;

    final long TEST_USER_ID = 12L;
    final String TEST_USER_NAME = "test";

    User mockUser;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        mockUser = new User();
        mockUser.setName(TEST_USER_NAME);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void getUser() {
        when(userRepository.findById(TEST_USER_ID)).thenReturn(Optional.of(mockUser));
        Optional<User> targetUser = userService.getUser(TEST_USER_ID);

        if (targetUser.isPresent()) {
            assertThat(mockUser).isEqualTo(targetUser.get());
            return;
        }

        fail("타겟 엔티티 가져오기 실패 ");

    }

    @Test
    void deleteUser() {
        try {
            when(userRepository.findById(TEST_USER_ID)).thenReturn(Optional.of(mockUser));
            userService.deleteUser(TEST_USER_ID);
        } catch (Exception e) {
            fail("타겟 엔티티 삭제 실패");
            throw e;
        }
    }
}