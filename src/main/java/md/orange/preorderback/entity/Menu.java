package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "menus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq", allocationSize = 1)
    private Long id;


    @JoinColumn(name = "locationId", foreignKey = @ForeignKey(name = "FK_LOCATION_MENU"))
    private Long locationId;
}
