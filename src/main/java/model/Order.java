package model;

import enumerate.Menu;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }
}
