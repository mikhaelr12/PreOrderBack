package md.orange.preorderback.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import md.orange.preorderback.dto.TableDTO;
import md.orange.preorderback.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/table-manager")
public class TableController {
    private final TableService tableService;

    @GetMapping
    @Operation(summary = "Get All Tables", description = "Retrieve all tables")
    public ResponseEntity<List<TableDTO>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTables());
    }

    @PostMapping
    @Operation(summary = "Add New Table", description = "Add a new table")
    public ResponseEntity<TableDTO> addTable(@RequestBody TableDTO tableDTO) {
        return ResponseEntity.ok(tableService.addTable(tableDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Table", description = "Delete a table by ID")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/location/{locationId}")
    @Operation(summary = "Get Tables by Location", description = "Retrieve tables for a specific location")
    public ResponseEntity<List<TableDTO>> getTablesByLocationId(@PathVariable Long locationId) {
        return ResponseEntity.ok(tableService.getTablesByLocationId(locationId));
    }
}
