package az.company.msorder.model.request;

import az.company.msorder.model.enums.PaymentType;
import az.company.msorder.model.constants.ApplicationConstants;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateOrderRequest {

    @NotNull(message = ApplicationConstants.PRODUCT_ID_IS_REQUIRED)
    Long productId;
    @NotNull(message =ApplicationConstants.QUANTITY_IS_REQUIRED )
    Integer quantity;
    PaymentType paymentType;
}
