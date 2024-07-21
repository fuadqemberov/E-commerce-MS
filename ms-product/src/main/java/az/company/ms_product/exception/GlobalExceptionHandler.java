package az.company.ms_product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(NotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
 public ErrorResponses handle(NotFoundException exception){
    return ErrorResponses
            .builder()
            .message(exception.getMessage())
            .build();
}

//@ExceptionHandler(Exception.class)
//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//public ErrorResponses handle(Exception exception){
//    return ErrorResponses
//            .builder()
//            .message(INTERNAL_SERVER_ERROR.getMessage())
//            .build();
//}

@ExceptionHandler(MethodArgumentNotValidException.class )
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorResponses hadle(MethodArgumentNotValidException exception){
    return ErrorResponses
            .builder()
            .message(exception.getBindingResult().getFieldError().getDefaultMessage())
            .build();
}

}
