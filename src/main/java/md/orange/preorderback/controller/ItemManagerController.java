package md.orange.preorderback.controller;

import lombok.*;
import md.orange.preorderback.dto.ItemDTO;
import md.orange.preorderback.service.ItemManagerService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item-manager")
@AllArgsConstructor
public class ItemManagerController {

    private final ItemManagerService itemManagerService;
    @PostMapping()
    public ResponseEntity<?> addItem(@RequestBody ItemDTO itemDTO) {
        itemManagerService.addItem(itemDTO);
        return ResponseEntity.ok("Item added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemManagerService.deleteItem(id);
        return ResponseEntity.ok("Item deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        itemManagerService.updateItem(id, itemDTO);
        return ResponseEntity.ok("Item updated");
    }
}
