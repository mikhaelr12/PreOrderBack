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
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "userId",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_BOOKING"))
    private Long userId;

    @Column(name = "tableId",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_RESTAURANTTABLE_BOOKING"))
    private Long tableId;

    @Column(name = "locationId", nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LOCATION_BOOKING"))
    private Long locationId;

    @Column(name = "bookingStatus")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "orderTime")
    private LocalDateTime orderTime;

    @Column(name = "numOfPeople")
    private int numOfPeople;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "finalPrice")
    private int finalPrice;
}
