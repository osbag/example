package example.service;

import de.osbag.example.ExampleApplication;
import de.osbag.example.dto.UserRequestDto;
import de.osbag.example.repository.UserBaseRepository;
import de.osbag.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * Currently I just used a simple Integration test scenario as the business requirement was simple
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
@EnableJpaRepositories("de.osbag.example.repository")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserBaseRepository userBaseRepository;

    @Test()
    public void saveUser() throws Exception {
            UserRequestDto dto = new UserRequestDto("test_F", "test_L", new Random().nextInt(900) * 0.1, new Random().nextInt(900) * 0.1,
                    LocalDate.now().minusDays(new Random().nextInt(900)));
        Long userId=userService.saveUser(dto).getId();
        Assert.assertEquals(userId, userBaseRepository.FindOne(userId).getId());

    }


}