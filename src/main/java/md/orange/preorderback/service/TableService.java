package md.orange.preorderback.service;

import md.orange.preorderback.dto.TableDTO;

import java.util.List;

public interface TableService {
    List<TableDTO> getAllTables();
    TableDTO addTable(TableDTO tableDTO);
    void deleteTable(Long id);
    List<TableDTO> getTablesByLocationId(Long locationId);
}
