package az.company.ms_product.mapper;

import az.company.ms_product.entity.Product;
import az.company.ms_product.model.request.CreateProductRequest;
import az.company.ms_product.model.response.ResponseProduct;

public enum ProductMapper {

    PRODUCT_MAPPER;

    public Product buildProductEntity(CreateProductRequest request){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
    }

    public ResponseProduct buildProductResponse(Product product) {
        return ResponseProduct.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity()).build();
    }
}
