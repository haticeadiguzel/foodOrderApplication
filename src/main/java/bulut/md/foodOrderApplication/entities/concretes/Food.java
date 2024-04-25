package bulut.md.foodOrderApplication.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
public class Food {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_price")
    private BigDecimal foodPrice;

    @OneToMany(mappedBy = "food")
//    @JsonIgnore
    private List<Order> orders;
}
