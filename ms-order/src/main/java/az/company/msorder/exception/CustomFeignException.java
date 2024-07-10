package az.company.msorder.exception;

public class CustomFeignException extends RuntimeException {
    public CustomFeignException(String s) {
        super(s);
    }
}
