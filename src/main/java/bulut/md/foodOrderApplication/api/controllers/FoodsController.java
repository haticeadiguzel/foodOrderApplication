package bulut.md.foodOrderApplication.api.controllers;

import bulut.md.foodOrderApplication.business.abstracts.FoodService;
import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateFoodRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllFoodsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/foods")
public class FoodsController {
    private FoodService foodService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllFoodsResponse>>> getAll() {
        DataResult<List<GetAllFoodsResponse>> dataResult = foodService.getAll();
        return ResponseEntity.ok(dataResult);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateFoodRequest createFoodRequest) {
        Result result = foodService.add(createFoodRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
