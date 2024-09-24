package md.orange.preorderback.repository;

import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.entity.Menu;
import md.orange.preorderback.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
