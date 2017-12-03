package fromBoris;

import static org.junit.Assert.*;

import fromBoris.interfaces.Quoter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuoterTest {

  private ClassPathXmlApplicationContext context;

  @Before
  public void before() {
    context = new ClassPathXmlApplicationContext(
        "borisExamples.xml");
  }

  @Test
  public void testHowMuchPhases() throws Exception {
    Quoter quoter = (Quoter) context.getBean("quoter");
    assertEquals(3, quoter.phase());
  }

  @Test
  public void sayQuote() throws Exception {
    Quoter quoter = (Quoter) context.getBean("quoter");
    assertEquals("Day good, when you smile", quoter.sayQuote());
  }

  @Test
  public void SayQuoteOnRandomRepeat() throws Exception {
    Quoter quoter = (Quoter) context.getBean("quoter");
    int random = quoter.repeat();

    if (random < 2 || random > 9) {
      assertFalse(true);
    } else {
      assertTrue(true);
    }
  }

  @After
  public void end() {
   context.close();
  }

}