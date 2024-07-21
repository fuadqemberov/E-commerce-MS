package az.company.mspayment.controller;

import az.company.mspayment.model.request.CreatePaymentRequest;
import az.company.mspayment.model.response.PaymentResponse;
import az.company.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/payments")
public class PaymentContrroller {

    private final PaymentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse pay(@RequestBody CreatePaymentRequest request){
        return service.pay(request);
    }

}
