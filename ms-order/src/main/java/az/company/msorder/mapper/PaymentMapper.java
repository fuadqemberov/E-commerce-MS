package az.company.msorder.mapper;

import az.company.msorder.client.CreatePaymentRequest;
import az.company.msorder.entity.Order;
import az.company.msorder.model.request.CreateOrderRequest;
import az.company.msorder.model.response.OrderResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static az.company.msorder.model.enums.OrderStatus.PENDING;

public enum PaymentMapper {
     PAYMENT_MAPPER_;

    public CreatePaymentRequest buildPaymentRequest(Order order, BigDecimal totalAmount,CreateOrderRequest request){
        return CreatePaymentRequest.builder()
                .orderId(order.getId())
                .paymentAmount(totalAmount)
                .paymentType(request.getPaymentType())
                .referenceNumber(UUID.randomUUID().toString())
                .build();

    }
}
