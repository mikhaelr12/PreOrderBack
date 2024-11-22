package md.orange.preorderback.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.TableDTO;
import md.orange.preorderback.entity.Table;
import md.orange.preorderback.repository.TableRepository;
import md.orange.preorderback.service.TableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;

    @Override
    public List<TableDTO> getAllTables() {
        log.info("Fetching all tables");
        return tableRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TableDTO addTable(TableDTO tableDTO) {
        log.info("Adding a new table with data: {}", tableDTO);
        Table table = new Table();
        table.setLocationId(tableDTO.getLocationId());
        table.setIsFree(tableDTO.getIsFree());
        Table savedTable = tableRepository.save(table);
        log.info("Added new table with ID: {}", savedTable.getId());
        return convertToDTO(savedTable);
    }

    @Override
    public void deleteTable(Long id) {
        log.info("Attempting to delete table with ID: {}", id);
        if (!tableRepository.existsById(id)) {
            log.error("Table with ID {} does not exist", id);
            throw new RuntimeException("Table not found");
        }
        tableRepository.deleteById(id);
        log.info("Deleted table with ID: {}", id);
    }

    @Override
    public List<TableDTO> getTablesByLocationId(Long locationId) {
        log.info("Fetching tables for location ID: {}", locationId);
        return tableRepository.getTablesByLocationId(locationId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TableDTO convertToDTO(Table table) {
        return TableDTO.builder()
                .id(table.getId())
                .locationId(table.getLocationId())
                .isFree(table.getIsFree())
                .build();
    }
}
