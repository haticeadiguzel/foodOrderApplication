package bulut.md.foodOrderApplication.business.abstracts;

import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateOrderRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllOrdersResponse;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetByOrderResponse;

import java.util.List;

public interface OrderService {
    DataResult<List<GetAllOrdersResponse>> getAll();
    DataResult<List<GetByOrderResponse>> getByCustomerName(String customerName);
    Result add(CreateOrderRequest createOrderRequest);
}
