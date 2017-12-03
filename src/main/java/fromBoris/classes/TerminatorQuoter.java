package fromBoris.classes;

import fromBoris.annotations.DeprecatedClass;
import fromBoris.annotations.InjectRandomInt;
import fromBoris.annotations.PostProxyListener;
import fromBoris.annotations.Profiling;
import fromBoris.interfaces.Quoter;
import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

  private int stages;

  @InjectRandomInt( min = 2, max = 9)
  private int repeat;

  private String message;

  @PostProxyListener
  public void stepThree() {
    stages++;
  }

  @PostConstruct
  public void init() {
    stages++;
  }

  public TerminatorQuoter() {
    stages++;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int repeat() {
    return repeat;
  }

  public int phase() {
    return stages;
  }

  public String sayQuote() {
    return message;
  }
}
