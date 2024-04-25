package bulut.md.foodOrderApplication.entities.dtos.requests;

import bulut.md.foodOrderApplication.entities.concretes.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private Food food;
    private String customerName;
}
