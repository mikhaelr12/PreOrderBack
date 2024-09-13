package md.orange.preorderback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.orange.preorderback.enums.Status;

import java.time.LocalDateTime;

@Entity(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "FK_USER_BOOKING"))
    private Long userId;

    @JoinColumn(name = "tableId", foreignKey = @ForeignKey(name = "FK_RESTAURANTTABLE_BOOKING"))
    private Long tableId;

    @Column(nullable = false)
    @JoinColumn(name = "locationId", foreignKey = @ForeignKey(name = "FK_LOCAATION_BOOKING"))
    private Long locationId;

    @Column(name = "bookingStatus")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "orderTime")
    private LocalDateTime orderTime;

    @Column(name = "numofPersons")
    private int numofPersons;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "finalPrice")
    private int finalPrice;
}
