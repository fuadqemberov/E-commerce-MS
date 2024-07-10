package az.company.msorder.mapper;

import az.company.msorder.entity.Order;
import az.company.msorder.model.enums.OrderStatus;
import az.company.msorder.model.request.CreateOrderRequest;
import az.company.msorder.model.response.OrderResponse;

import java.time.LocalDateTime;

import static az.company.msorder.model.enums.OrderStatus.PENDING;
import static java.time.LocalTime.now;

public enum OrderMapper {
     ORDER_MAPPER;

    public Order buildOrderEntity(CreateOrderRequest createOrderRequest) {
        return Order.builder()
                .productId(createOrderRequest.getProductId())
                .quantity(createOrderRequest.getQuantity())
                .status(PENDING)
                .createdAt(LocalDateTime.now())
                .build();
    }



    public OrderResponse buildOrderResponse(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .amount(order.getAmount())
                .createdAt(order.getCreatedAt())
                .quantity(order.getQuantity())
                .status(order.getStatus()).build();
    }
}
