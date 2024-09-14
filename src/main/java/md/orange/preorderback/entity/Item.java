package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "dish_name", nullable = false, unique = true)
    private String dish_name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(name = "FK_MENU_ITEM"))
    private Long menu_id;

    @Column(name = "is_available")
    private boolean is_available;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
