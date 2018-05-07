package controllerTest;

import static org.junit.Assert.assertEquals;


import com.task19.jxmall.JxmallApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = JxmallApplication.class)
public class HelloControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void shouldSayAnotherHelloWorld() {
    String result = restTemplate.getForObject("/hello", String.class);
    assertEquals("hello", result);
  }
}