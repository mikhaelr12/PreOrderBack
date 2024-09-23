package md.orange.preorderback.repository;

import md.orange.preorderback.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> getTablesByLocationId(Long locationId);
}
