import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.UserService;
import vo.UserVO;

/**
 * Created by ldchao on 2017/4/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class LoginTest {

    @Autowired
    UserService userService;

    @Test
    public void login(){
       UserVO userVO=userService.login("hhhh","123");
       if(userVO==null){
           System.out.println("hhhhhhhhhhhhhhhhhhh");
       }
    }
}
