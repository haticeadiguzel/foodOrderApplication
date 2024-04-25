package bulut.md.foodOrderApplication.business.concretes;

import bulut.md.foodOrderApplication.business.abstracts.FoodService;
import bulut.md.foodOrderApplication.core.utilities.mappers.ModelMapperService;
import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.core.utilities.results.SuccessDataResult;
import bulut.md.foodOrderApplication.core.utilities.results.SuccessResult;
import bulut.md.foodOrderApplication.dataAccess.abstracts.FoodRepository;
import bulut.md.foodOrderApplication.entities.concretes.Food;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateFoodRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllFoodsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodManager implements FoodService {
    private FoodRepository foodRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllFoodsResponse>> getAll() {
        List<Food> foods = foodRepository.findAll();
        List<GetAllFoodsResponse> foodsResponses = foods.stream().map(food -> modelMapperService.forResponse().map(food, GetAllFoodsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllFoodsResponse>>(foodsResponses, "Foods Listed.");
    }

    @Override
    public Result add(CreateFoodRequest createFoodRequest) {
        Food food = modelMapperService.forRequest().map(createFoodRequest, Food.class);
        foodRepository.save(food);

        return new SuccessResult("Food Added.");
    }
}
