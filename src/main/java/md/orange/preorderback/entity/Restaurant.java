package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Lob
    @Column(name = "logo")
    private Byte[] logo;

    @Column(name = "category_id")
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_CATEGORY_RESTAURANT"))
    private Long categoryId;
}
