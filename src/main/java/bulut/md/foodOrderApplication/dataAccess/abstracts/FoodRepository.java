package bulut.md.foodOrderApplication.dataAccess.abstracts;

import bulut.md.foodOrderApplication.entities.concretes.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findByFoodName(String customerName);
}
