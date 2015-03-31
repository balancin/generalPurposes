package amazingcep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.balancin.amazingcep.AmazingCepApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmazingCepApplication.class)
@WebAppConfiguration
public class AmazingCepApplicationTests {

	@Test
	public void contextLoads() {
	}

}
