package az.company.msorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "ms-payment",
        url = "http://localhost:8082/v1/payments",
        configuration = CustomErrorDecoder.class)
public interface PaymentClient {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void PaymentResponse (@RequestBody CreatePaymentRequest request);
}
