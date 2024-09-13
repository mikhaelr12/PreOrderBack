package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "restaurantTables")
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurantTable_id_seq")
    @SequenceGenerator(name = "restaurantTable_id_seq", sequenceName = "restaurantTable_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "locationId")
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LOCATION_RESTAURANTTABLE"))
    private Long locationId;
}
