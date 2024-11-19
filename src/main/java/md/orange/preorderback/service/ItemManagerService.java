package md.orange.preorderback.service;

import md.orange.preorderback.dto.ItemDTO;

public interface ItemManagerService {
    void addItem(ItemDTO itemDTO );
    void deleteItem(Long id);

    void updateItem(Long id, ItemDTO itemDTO);
}
