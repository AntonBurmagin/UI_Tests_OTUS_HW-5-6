package exceptions;

public class ComponentByTypeNotFoundException extends RuntimeException {
    public ComponentByTypeNotFoundException() {
      super("Selector type not found!");
    }
}
