package az.company.msorder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@ExceptionHandler(CustomFeignException.class)
public ResponseEntity<ErrorResponses> handle(CustomFeignException exception){
    return ResponseEntity
            .status(exception.getStatusCode())
            .body(ErrorResponses.builder()
                    .message(exception.getMessage())
                    .build());
}

@ExceptionHandler(Exception.class)
public ErrorResponses handle(Exception exception){
    return ErrorResponses
            .builder()
            .message(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage())
            .build();
}

@ExceptionHandler(MethodArgumentNotValidException.class )
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorResponses handle(MethodArgumentNotValidException exception){
    return ErrorResponses
            .builder()
            .message(exception.getBindingResult().getFieldError().getDefaultMessage())
            .build();
}

}
