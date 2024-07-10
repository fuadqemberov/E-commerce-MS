package az.company.ms_product.service;

import az.company.ms_product.model.request.CreateProductRequest;
import az.company.ms_product.model.request.ReduceQuantityRequest;
import az.company.ms_product.model.response.ResponseProduct;

public interface ProductService {

    void createProduct(CreateProductRequest request);

    ResponseProduct getProductById(Long id);

    void reduceQuantity(ReduceQuantityRequest request);
}
