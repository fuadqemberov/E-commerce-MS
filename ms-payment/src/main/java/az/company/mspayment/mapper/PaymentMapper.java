package az.company.mspayment.mapper;

import az.company.mspayment.entity.Payment;
import az.company.mspayment.model.request.CreatePaymentRequest;

import java.time.LocalDateTime;

import static az.company.mspayment.model.enums.PaymentStatus.SUCCESS;

public enum PaymentMapper {
    PAYMENT_MAPPER;

    public Payment buildPaymentEntity(CreatePaymentRequest request){
       return Payment.builder()
               .paymnetStatus(SUCCESS)
               .referenceNumber(request.getReferenceNumber())
               .amount(request.getPaymentAmount())
               .createdAt(LocalDateTime.now())
               .paymentType(request.getPaymentType())
               .build();
    }
}
