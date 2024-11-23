package md.orange.preorderback.service;

import md.orange.preorderback.dto.MenuDTO;

public interface MenuManagerService {
    void updateMenu(Long id, MenuDTO menuDTO);

    void deleteMenu(Long id);

    void addMenu(MenuDTO menuDTO, Long restaurantId);
}
