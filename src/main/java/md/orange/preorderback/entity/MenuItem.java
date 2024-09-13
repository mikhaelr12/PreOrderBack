package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "menuItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuItem_id_seq")
    @SequenceGenerator(name = "menuItem_id_seq", sequenceName = "menuItem_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "dishName", nullable = false, unique = true)
    private String dishName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(name = "FK_MENU_ITEM"))
    private Long menuId;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
