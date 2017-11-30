package some.thing.Implements;

import some.thing.Interfaces.ConvertIntInString;

public class ConvertInEngString implements ConvertIntInString {

  private int digit;

  public void setDigit(int digit) {
    this.digit = digit;
  }

  public String parseIntInString() {

    if (digit < 0 || digit > 10) {
      throw new IllegalArgumentException("Please use period from 0 - 10");
    }

    switch (digit) {
      case 1:
        return "One";
      case 2:
        return "Two";
      case 3:
        return "Three";
      case 4:
        return "Fore";
      case 5:
        return "Five";
      case 6:
        return "Six";
      case 7:
        return "Seven";
      case 8:
        return "Eight";
      case 9:
        return "Nine";
      case 0:
        return "Zero";
    }

    return null;
  }
}
