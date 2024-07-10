package az.company.ms_product.service.impl;

import az.company.ms_product.entity.Product;
import az.company.ms_product.exception.InsufficientQuantityException;
import az.company.ms_product.exception.NotFoundException;
import az.company.ms_product.mapper.ProductMapper;
import az.company.ms_product.model.request.CreateProductRequest;
import az.company.ms_product.model.request.ReduceQuantityRequest;
import az.company.ms_product.model.response.ResponseProduct;
import az.company.ms_product.repository.ProductRepository;
import az.company.ms_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.company.ms_product.exception.ErrorMessages.*;
import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public void createProduct(CreateProductRequest request) {
      repository.save(ProductMapper.PRODUCT_MAPPER.buildProductEntity(request));
    }

    @Override
    public ResponseProduct getProductById(Long id) {
        return repository.findById(id)
                .map(ProductMapper.PRODUCT_MAPPER::buildProductResponse)
                .orElseThrow(()->new NotFoundException(
                        format(
                                PRODUCT_NOT_FOUND.getMessage(),
                                id)
                ));

    }

    @Override
    public void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest) {
        Product productEntity =
                repository.findById(reduceQuantityRequest.getProductId())
                        .orElseThrow(() -> new NotFoundException(
                                format(
                                        PRODUCT_NOT_FOUND.getMessage(),
                                        reduceQuantityRequest.getProductId()
                                )
                        ));

        if (productEntity.getQuantity() < reduceQuantityRequest.getQuantity()) {
            throw new InsufficientQuantityException(
                    format(
                            INSUFFICIENT_QUANTITY.getMessage(),
                            reduceQuantityRequest.getProductId()
                    ));
        }

        productEntity.setQuantity(
                productEntity.getQuantity() - reduceQuantityRequest.getQuantity()
        );
        repository.save(productEntity);
    }
}
