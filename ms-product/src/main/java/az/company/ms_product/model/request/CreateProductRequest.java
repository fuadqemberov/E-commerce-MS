package az.company.ms_product.model.request;

import az.company.ms_product.model.request.constants.ApplicationsConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {

    @NotBlank(message = ApplicationsConstants.NAME_IS_REQUIRED)
    String name;
    @NotBlank(message =ApplicationsConstants.DESCRIPTION_IS_REQUIRED )
    String description;
    @NotNull(message = ApplicationsConstants.PRICE_IS_REQUIRED)
    BigDecimal price;
    @NotNull(message = ApplicationsConstants.QUANTITY_IS_REQUIRED)
    Integer quantity;



}
