package az.company.mspayment.service;

import az.company.mspayment.entity.Payment;
import az.company.mspayment.model.request.CreatePaymentRequest;
import az.company.mspayment.model.response.PaymentResponse;
import az.company.mspayment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.company.mspayment.mapper.PaymentMapper.PAYMENT_MAPPER;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository repository;

    @Override
    public PaymentResponse pay(CreatePaymentRequest request) {
        Payment payment = PAYMENT_MAPPER.buildPaymentEntity(request);
        repository.save(payment);
        return new PaymentResponse(payment.getId());
    }
}
