package bulut.md.foodOrderApplication.dataAccess.abstracts;

import bulut.md.foodOrderApplication.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
