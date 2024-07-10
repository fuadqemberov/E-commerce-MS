package az.company.ms_product.controller;

import az.company.ms_product.model.request.CreateProductRequest;
import az.company.ms_product.model.request.ReduceQuantityRequest;
import az.company.ms_product.model.response.ResponseProduct;
import az.company.ms_product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/prodcuts")
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductRequest request){
        service.createProduct(request);
    }

    @GetMapping("/{id}")
    public ResponseProduct getById(@PathVariable Long id){
       return service.getProductById(id);
    }

    @PostMapping("/reduce-quantity")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reduceQuantity(@RequestBody @Valid ReduceQuantityRequest request){
        service.reduceQuantity(request);
    }
}
