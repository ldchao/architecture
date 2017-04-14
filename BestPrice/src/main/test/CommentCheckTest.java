import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.commentmanage.check.SensitiveCheck;

/**
 * Created by LHS on 2017/4/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class CommentCheckTest {

    @Autowired
    SensitiveCheck sensitiveCheck;

    @Test
    public void check(){

        sensitiveCheck.checkComment("这是一个垃圾评论", 1, 1);
    }
}
