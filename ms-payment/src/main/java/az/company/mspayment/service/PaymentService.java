package az.company.mspayment.service;

import az.company.mspayment.model.request.CreatePaymentRequest;
import az.company.mspayment.model.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse pay(CreatePaymentRequest request);
}
