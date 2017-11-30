package some.thing.Implements;

import some.thing.Interfaces.ConvertIntInString;

public class ConvertInRusString implements ConvertIntInString {

  private int digit;

  public void setDigit(int digit) {
    this.digit = digit;
  }

  public String parseIntInString() {
    if (digit < 0 || digit > 10) {
      throw new IllegalArgumentException("Пожалуйста введите в пределах от 0 - 10");
    }

    switch (digit) {
      case 1:
        return "Один";
      case 2:
        return "Два";
      case 3:
        return "Три";
      case 4:
        return "Четыре";
      case 5:
        return "Пять";
      case 6:
        return "Шесть";
      case 7:
        return "Семь";
      case 8:
        return "Восемь";
      case 9:
        return "Девять";
      case 0:
        return "Ноль";
    }

    return null;
  }
}
