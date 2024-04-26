package bulut.md.foodOrderApplication.business.concretes;

import bulut.md.foodOrderApplication.business.abstracts.OrderService;
import bulut.md.foodOrderApplication.core.utilities.mappers.ModelMapperService;
import bulut.md.foodOrderApplication.core.utilities.results.*;
import bulut.md.foodOrderApplication.dataAccess.abstracts.FoodRepository;
import bulut.md.foodOrderApplication.dataAccess.abstracts.OrderRepository;
import bulut.md.foodOrderApplication.entities.concretes.Food;
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
    private FoodRepository foodRepository;
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
        if (orders.isEmpty()) {
            return new ErrorDataResult<List<GetByOrderResponse>>("Order with customer name " + customerName + " not found.");
        }

        List<GetByOrderResponse> orderResponses = orders.stream().map(order -> modelMapperService.forResponse().map(order, GetByOrderResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByOrderResponse>>(orderResponses, "Orders Listed.");
    }

    @Override
    public Result add(CreateOrderRequest createFoodRequest) {
        String foodName = createFoodRequest.getFoodName();
        String customerName = createFoodRequest.getCustomerName();

        Food food = foodRepository.findByFoodName(foodName);

        if (food == null) {
            return new ErrorResult("Food with name " + foodName + " not found.");
        }

        Order order = new Order();
        order.setFood(food);
        order.setCustomerName(customerName);

        orderRepository.save(order);

        return new SuccessResult("Order Added.");
    }
}
