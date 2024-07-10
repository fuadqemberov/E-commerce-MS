package az.company.msorder.service;

import az.company.msorder.model.request.CreateOrderRequest;
import az.company.msorder.model.response.OrderResponse;

public interface OrderService {
    void createOrder(CreateOrderRequest createOrderRequest);
    OrderResponse getById(Long id);
}
