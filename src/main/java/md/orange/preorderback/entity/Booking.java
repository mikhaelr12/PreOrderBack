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

    @Column(name = "table_id")
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_TABLE_BOOKING"))
    private Long tableId;

    @Column(name = "location_id",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LOCATION_BOOKING"))
    private Long locationId;

    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private Status bookingStatus;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Column(name = "no_people")
    private Integer noPeople;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "final_price")
    private Double finalPrice;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

}
