package md.orange.preorderback.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.ItemDTO;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.entity.Item;
import md.orange.preorderback.entity.Menu;
import md.orange.preorderback.repository.ItemRepository;
import md.orange.preorderback.repository.MenuRepository;
import md.orange.preorderback.service.MenuManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuManagerServiceImpl implements MenuManagerService {

    private final MenuRepository menuRepository;
    private final ItemRepository itemRepository;

    @Override
    public void addMenu(MenuDTO menuDTO, Long restaurantId) {
        // Salvare meniu
        Menu menu = Menu.builder()
                .restaurantId(restaurantId)
                .build();
        menu = menuRepository.save(menu);

        // Salvare items asociate
        if (menuDTO.getItems() != null) {
            Menu finalMenu = menu;
            List<Item> items = menuDTO.getItems().stream()
                    .map(itemDTO -> Item.builder()
                            .dishName(itemDTO.getDishName())
                            .price(itemDTO.getPrice())
                            .menuId(finalMenu.getId())
                            .description(itemDTO.getDescription())
                            .isAvailable(itemDTO.getIsAvailable())
                            .build())
                    .collect(Collectors.toList());
            itemRepository.saveAll(items);
        }
    }

    @Transactional
    @Override
    public void deleteMenu(Long id) {
        // Ștergere items asociate
        itemRepository.deleteByMenuId(id);
        // Ștergere meniu
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found!"));
        menuRepository.delete(menu);
    }

    @Override
    public void updateMenu(Long id, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found!"));

        // Actualizare items asociate
        if (menuDTO.getItems() != null) {
            // Ștergere items existente și salvare items noi
            itemRepository.deleteByMenuId(menu.getId());
            List<Item> items = menuDTO.getItems().stream()
                    .map(itemDTO -> Item.builder()
                            .dishName(itemDTO.getDishName())
                            .price(itemDTO.getPrice())
                            .menuId(menuDTO.getId())
                            .description(itemDTO.getDescription())
                            .isAvailable(itemDTO.getIsAvailable())
                            .build())
                    .collect(Collectors.toList());
            itemRepository.saveAll(items);
        }
    }
}
