package bulut.md.foodOrderApplication.entities.dtos.responses;

import bulut.md.foodOrderApplication.entities.concretes.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOrdersResponse {
    private int id;
    private Food food;
    private String customerName;
}
