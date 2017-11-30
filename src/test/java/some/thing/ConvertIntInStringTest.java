package some.thing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import some.thing.Interfaces.ConvertIntInString;

public class ConvertIntInStringTest {

  private ApplicationContext context;

  @Before
  public void setUp() {
    context = new ClassPathXmlApplicationContext("spring-context.xml");
  }

  @Test
  public void checkConfigs() throws Exception {
    assertNotNull(context);
    assertEquals(2, context.getBeanDefinitionCount());
  }

  @Test
  public void parseIntInRusString() throws Exception {

    ConvertIntInString parser = (ConvertIntInString) context.getBean("convertRus");
    assertEquals("Четыре", parser.parseIntInString());
  }

  @Test
  public void parseIntInEngString() throws Exception {

    ConvertIntInString parser = (ConvertIntInString) context.getBean("convertEng");
    assertEquals("Zero", parser.parseIntInString());
  }

  @After
  public void tearDown() {
    ((ConfigurableApplicationContext) context).close();
  }

}