package fromBoris.screenSaver;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

  @Test
  public void testFrame() throws Exception {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        Config.class);
    while (true) {
      context.getBean(AbstractColorFrame.class).showOnRandomPase();
      Thread.sleep(100);
    }
  }

}