public class TooFewItemsException extends RuntimeException {
    public TooFewItemsException() {
        super();
    }

    public TooFewItemsException(String str) {
        super(str);
    }
}
