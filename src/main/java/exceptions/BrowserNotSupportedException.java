package exceptions;

public class BrowserNotSupportedException extends RuntimeException{

  public BrowserNotSupportedException(String browser) {
    super(String.format("%s browser is not supported!", browser));
  }
}
