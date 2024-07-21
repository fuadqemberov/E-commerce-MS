package az.company.msorder.exception;

import lombok.Getter;

@Getter
public class CustomFeignException extends RuntimeException {

    Integer statusCode;
    public CustomFeignException(String message,Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
