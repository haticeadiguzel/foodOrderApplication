package bulut.md.foodOrderApplication.business.concretes;

import bulut.md.foodOrderApplication.business.abstracts.OrderService;
import bulut.md.foodOrderApplication.core.utilities.mappers.ModelMapperService;
import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.core.utilities.results.SuccessDataResult;
import bulut.md.foodOrderApplication.core.utilities.results.SuccessResult;
import bulut.md.foodOrderApplication.dataAccess.abstracts.OrderRepository;
import bulut.md.foodOrderApplication.entities.concretes.Order;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateOrderRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllOrdersResponse;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetByOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllOrdersResponse>> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<GetAllOrdersResponse> ordersResponses = orders.stream().map(order -> modelMapperService.forResponse().map(order, GetAllOrdersResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(ordersResponses, "Orders Listed.");
    }

    @Override
    public DataResult<List<GetByOrderResponse>> getByCustomerName(String customerName) {
        List<Order> orders = orderRepository.getByCustomerName(customerName);
        List<GetByOrderResponse> orderResponses = orders.stream().map(order -> modelMapperService.forResponse().map(order, GetByOrderResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByOrderResponse>>(orderResponses, "Orders Listed.");
    }

    @Override
    public Result add(CreateOrderRequest createFoodRequest) {
        Order order = modelMapperService.forRequest().map(createFoodRequest, Order.class);
        orderRepository.save(order);

        return new SuccessResult("Order Added.");
    }
}
