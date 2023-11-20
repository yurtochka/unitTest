package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void testLogOutExceptAdministrators(){
        UserRepository userRepository = new UserRepository();

        User admin = new User("Admin", "Admin", true);
        User simpleUser = new User("Ivan", "12345", false);

        userRepository.addUser(admin);
        userRepository.addUser(simpleUser);

        admin.isAuthenticate = true;
        simpleUser.isAuthenticate = true;

        assertTrue(admin.isAuthenticate);
        assertTrue(simpleUser.isAuthenticate);

    }
}