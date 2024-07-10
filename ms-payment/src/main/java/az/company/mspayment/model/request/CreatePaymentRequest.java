package az.company.mspayment.model.request;

import az.company.mspayment.model.enums.PaymentStatus;
import az.company.mspayment.model.enums.PaymentType;
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
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePaymentRequest {
    Long orderId;
    PaymentType paymentType;
    PaymentStatus status;
    String referenceNumber;
    String paymentDate;
    BigDecimal paymentAmount;
}
