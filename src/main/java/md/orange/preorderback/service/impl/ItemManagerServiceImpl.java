package md.orange.preorderback.service.impl;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.ItemDTO;
import md.orange.preorderback.entity.Item;
import md.orange.preorderback.repository.ItemRepository;
import md.orange.preorderback.service.ItemManagerService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemManagerServiceImpl implements ItemManagerService {

    private ItemRepository itemRepository;
    @Override
    public void addItem(ItemDTO itemDTO) {
        itemRepository.save(Item.builder()
                        .price(itemDTO.getPrice())
                        .description(itemDTO.getDescription())
                        .dishName(itemDTO.getDishName())
                        .menuId(itemDTO.getMenuId())
                        .isAvailable(true)
                .build());
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).get();
        itemRepository.delete(item);
    }

    @Override
    public void updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id).get();
        if (itemDTO.getPrice() != null) {
            item.setPrice(itemDTO.getPrice());
        }

        if (itemDTO.getDescription() != null) {
            item.setDescription(itemDTO.getDescription());
        }

        if (itemDTO.getDishName() != null) {
            item.setDishName(itemDTO.getDishName());
        }

        if (itemDTO.getMenuId() != null) {
            item.setMenuId(itemDTO.getMenuId());
        }
        itemRepository.save(item);
    }
}
