package bulut.md.foodOrderApplication.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFoodsResponse {
    private int id;
    private String foodName;
    private BigDecimal foodPrice;

}
