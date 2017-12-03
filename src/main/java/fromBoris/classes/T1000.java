package fromBoris.classes;

import fromBoris.annotations.InjectRandomInt;

public class T1000 extends TerminatorQuoter {

  @InjectRandomInt(min = 2, max = 9)
  private int repeat;

  @Override
  public int repeat() {
    return repeat;
  }

  @Override
  public String sayQuote() {
    return "New day, new life";
  }
}
