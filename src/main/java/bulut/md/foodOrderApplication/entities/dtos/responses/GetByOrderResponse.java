package bulut.md.foodOrderApplication.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByOrderResponse {
    private int id;
    private String foodName;
    private int foodPrice;
    private String customerName;
}