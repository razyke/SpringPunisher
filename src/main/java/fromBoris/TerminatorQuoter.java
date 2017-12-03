package fromBoris;

public class TerminatorQuoter implements Quoter {

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public String sayQuote() {
    return message;
  }
}
