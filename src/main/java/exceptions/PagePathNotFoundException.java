package exceptions;

public class PagePathNotFoundException extends RuntimeException {
    public PagePathNotFoundException() {
        super("Annotation path not found!");
    }
}
