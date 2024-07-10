package az.company.ms_product.model.request;

import az.company.ms_product.model.request.constants.ApplicationsConstants;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReduceQuantityRequest {
    @NotNull(message = ApplicationsConstants.PRODUCT_ID_IS_REQUIRED)
    private Long productId;

    @NotNull(message = ApplicationsConstants.QUANTITY_IS_REQUIRED)
    private Integer quantity;
}