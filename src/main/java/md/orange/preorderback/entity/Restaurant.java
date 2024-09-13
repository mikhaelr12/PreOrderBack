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

    @Column(name = "restaurantName", nullable = false)
    private String name;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "categoryId")
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_CATEGORY_RESTAURANT"))
    private Long categoryId;
}
