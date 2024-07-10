package az.company.msorder.client;

import az.company.msorder.model.response.ResponseProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="ms-product",url = "http://localhost:8081/v1/prodcuts",configuration = CustomErrorDecoder.class)
public interface ProductCilent {

    @PostMapping("/reduce-quantity")
    void reduceQuantity(@RequestBody ReduceQuantityRequest request);

    @GetMapping("/{id}")
    ResponseProduct getById(@PathVariable Long id);


}
