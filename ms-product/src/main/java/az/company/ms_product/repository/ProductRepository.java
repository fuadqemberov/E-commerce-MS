package az.company.ms_product.repository;

import az.company.ms_product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {

}
