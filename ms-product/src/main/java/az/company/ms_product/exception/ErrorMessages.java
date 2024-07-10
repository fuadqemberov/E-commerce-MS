package az.company.ms_product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product not found with id : %s"),
    INTERNAL_SERVER_ERROR("Unexcepted error occured.Please try again later"),
    INSUFFICIENT_QUANTITY("Insufficient quantity for product with id: %s");

    private final String message;
}
