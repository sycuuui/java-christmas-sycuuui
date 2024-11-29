package model;

import enumerate.menu.Menu;
import enumerate.menu.MenuGroup;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(String name, int quantity) {
        this.menu = Menu.findMenuByName(name);
        this.quantity = quantity;
    }

    public int orderPrice() {
        return menu.getPrice() * quantity;
    }

    public MenuGroup getMenuGroup() {
        return MenuGroup.findMenuGroupByMenu(menu);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getQuantity() {
        return quantity;
    }
}
