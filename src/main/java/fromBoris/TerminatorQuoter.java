package fromBoris;

public class TerminatorQuoter implements Quoter {

  @InjectRandomInt( min = 2, max = 9)
  private int repeat;

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public int repeat() {
    return repeat;
  }

  public String sayQuote() {
    return message;
  }
}
