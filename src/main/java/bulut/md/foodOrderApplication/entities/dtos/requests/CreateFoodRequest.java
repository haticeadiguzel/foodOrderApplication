package bulut.md.foodOrderApplication.entities.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFoodRequest {
    private String foodName;
    private BigDecimal foodPrice;
}
