package az.company.msorder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {
    ORDER_NOT_FOUND("Order not found with id : %s"),
    INTERNAL_SERVER_ERROR("Unexcepted error occured.Please try again later"),
    CLIENT_ERROR("Client error occured while making the request"),
    SERVER_ERROR("Server error occured while making the request");

    private final String message;
}
