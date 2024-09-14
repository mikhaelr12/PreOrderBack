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

    @Column(name = "user_id",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_BOOKING"))
    private Long user_id;

    @Column(name = "table_id",nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_TABLE_BOOKING"))
    private Long table_id;

    @Column(name = "location_id", nullable = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LOCATION_BOOKING"))
    private Long location_id;

    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private Status booking_status;

    @Column(name = "order_time")
    private LocalDateTime order_time;

    @Column(name = "no_people")
    private int no_people;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "final_price")
    private int final_price;
}
