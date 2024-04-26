package bulut.md.foodOrderApplication.api.controllers;

import bulut.md.foodOrderApplication.business.abstracts.OrderService;
import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateFoodRequest;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateOrderRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllOrdersResponse;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetByOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrdersController {
    private OrderService orderService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllOrdersResponse>>> getAll() {
        DataResult<List<GetAllOrdersResponse>> dataResult = orderService.getAll();
        return ResponseEntity.ok(dataResult);
    }

    @GetMapping("/getByCustomerName")
    public DataResult<List<GetByOrderResponse>> getByCustomerName(String customerName){
        return orderService.getByCustomerName(customerName);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateOrderRequest createFoodRequest) {
        Result result = orderService.add(createFoodRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
