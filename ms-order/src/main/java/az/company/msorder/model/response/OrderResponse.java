package az.company.msorder.model.response;

import az.company.msorder.model.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    Long id;
    Long productId;
    Integer quantity;
    OrderStatus status;
    BigDecimal amount;
    LocalDateTime createdAt;
    ResponseProduct  responseProduct;
}
