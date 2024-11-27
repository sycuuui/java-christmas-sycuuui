package model;

import enumerate.Menu;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(String name, int quantity) {
        this.menu = Menu.findMenuByName(name);
        this.quantity = quantity;
    }

}
