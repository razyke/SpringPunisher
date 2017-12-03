package fromBoris;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuoterTest {

  private ClassPathXmlApplicationContext context;

  @Before
  public void before() {
    context = new ClassPathXmlApplicationContext(
        "borisExamples.xml");

  }

  @Test
  public void sayQuote() throws Exception {
    Quoter quoter = (Quoter) context.getBean("quoter");
    assertEquals("Day good, when you smile", quoter.sayQuote());
  }

  @After
  public void end() {
   ((ConfigurableApplicationContext) context).close();
  }

}