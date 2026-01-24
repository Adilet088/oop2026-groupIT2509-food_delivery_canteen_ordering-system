package edu.aitu.oop3.model;

import edu.aitu.oop3.exception.MenuItemNotAvailableException;

import java.util.List;

public class MenuService {

    private MenuItemRepository menuRepo;

    public MenuService(MenuItemRepository menuRepo) {
        this.menuRepo = menuRepo;
    }

    public List<MenuItem> getMenu() {
        return menuRepo.findAll();
    }

    public List<MenuItem> getAvailableMenu() {
        return menuRepo.findAvailable();
    }

    public MenuItem requireAvailable(int menuItemId) {
        MenuItem item = menuRepo.findById(menuItemId);

        if (item == null) {
            throw new MenuItemNotAvailableException("Menu item not found: " + menuItemId);
        }
        if (!item.available) {
            throw new MenuItemNotAvailableException("Menu item is not available: " + item.name);
        }
        return item;
    }
}

