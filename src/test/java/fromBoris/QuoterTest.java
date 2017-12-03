package fromBoris;

import static org.junit.Assert.*;

import fromBoris.classes.PropertyFileApplicationContext;
import fromBoris.classes.T1000;
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
    if (!(quoter instanceof T1000)) {
      assertEquals("Day good, when you smile", quoter.sayQuote());
    } else {
      assertEquals("New day, new life", quoter.sayQuote());
    }
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

  @Test
  public void TestFromProperties() throws Exception {
    PropertyFileApplicationContext context = new PropertyFileApplicationContext(
        "borisExample.properties");
    String s = context.getBean(Quoter.class).sayQuote();
    assertEquals("Jasen come back here", s);

  }

  @After
  public void end() {
   context.close();
  }

}