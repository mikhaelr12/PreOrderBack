package md.orange.preorderback.repository;

import md.orange.preorderback.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository  extends JpaRepository<Booking, Long> {
    List<Booking> findAllByLocationId(Long locationId);
}
