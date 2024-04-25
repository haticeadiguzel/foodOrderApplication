package bulut.md.foodOrderApplication.business.abstracts;

import bulut.md.foodOrderApplication.core.utilities.results.DataResult;
import bulut.md.foodOrderApplication.core.utilities.results.Result;
import bulut.md.foodOrderApplication.entities.dtos.requests.CreateFoodRequest;
import bulut.md.foodOrderApplication.entities.dtos.responses.GetAllFoodsResponse;

import java.util.List;

public interface FoodService {
    DataResult<List<GetAllFoodsResponse>> getAll();
    Result add(CreateFoodRequest createFoodRequest);
}
