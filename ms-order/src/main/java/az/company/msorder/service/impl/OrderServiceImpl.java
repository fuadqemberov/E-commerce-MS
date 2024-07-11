package az.company.msorder.service.impl;

import az.company.msorder.client.CreatePaymentRequest;
import az.company.msorder.client.PaymentClient;
import az.company.msorder.client.ProductCilent;
import az.company.msorder.client.ReduceQuantityRequest;
import az.company.msorder.entity.Order;
import az.company.msorder.exception.NotFoundException;
import az.company.msorder.model.enums.OrderStatus;
import az.company.msorder.model.request.CreateOrderRequest;
import az.company.msorder.model.response.OrderResponse;
import az.company.msorder.model.response.ResponseProduct;
import az.company.msorder.repository.OrderRepository;
import az.company.msorder.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

import static az.company.msorder.exception.ErrorMessages.ORDER_NOT_FOUND;
import static az.company.msorder.mapper.OrderMapper.ORDER_MAPPER;
import static az.company.msorder.mapper.PaymentMapper.PAYMENT_MAPPER_;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductCilent cilent;
    private final PaymentClient paymentClient;

    @Override
    @Transactional
    public void createOrder(CreateOrderRequest createOrderRequest) {
        Order entity = ORDER_MAPPER.buildOrderEntity(createOrderRequest);
        ResponseProduct product = cilent.getById(createOrderRequest.getProductId());
        BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(createOrderRequest.getQuantity()));
        entity.setAmount(totalAmount);
        ReduceQuantityRequest reduceQuantity = new ReduceQuantityRequest
                (createOrderRequest.getProductId(),
                        createOrderRequest.getQuantity());

        repository.save(entity);
        cilent.reduceQuantity(reduceQuantity);
        try {
            CreatePaymentRequest paymentRequest = PAYMENT_MAPPER_.buildPaymentRequest(entity,
                    totalAmount,
                    createOrderRequest);
            paymentClient.pay(paymentRequest);
            entity.setStatus(OrderStatus.APPROVED);
        } catch (Exception ex) {
            entity.setStatus(OrderStatus.REJECTED);
        }

    }

    @Override
    public OrderResponse getById(Long id) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        format(ORDER_NOT_FOUND.getMessage(), id)
                ));
      ResponseProduct responseProduct =  cilent.getById(entity.getProductId());
      return ORDER_MAPPER.buildOrderResponse(entity,responseProduct);

    }
}
