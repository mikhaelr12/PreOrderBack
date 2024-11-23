package md.orange.preorderback.controller;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.service.MenuManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu-manager")
@AllArgsConstructor
public class MenuManagerController {

    private final MenuManagerService menuManagerService;

    @PostMapping
    public ResponseEntity<?> addMenu(@RequestBody MenuDTO menuDTO, @RequestParam Long restaurantId) {
        menuManagerService.addMenu(menuDTO, restaurantId);
        return ResponseEntity.ok("Menu added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long id) {
        menuManagerService.deleteMenu(id);
        return ResponseEntity.ok("Menu deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {
        menuManagerService.updateMenu(id, menuDTO);
        return ResponseEntity.ok("Menu updated");
    }
}
