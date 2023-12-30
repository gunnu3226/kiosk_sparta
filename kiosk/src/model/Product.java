package model;

import model.Menu;

public class Product extends Menu {
    private double price;
    private int productNumber;

    public Product(String menuName, String menuExplain, double price, int menuType, int productNumber) {
        super(menuName, menuExplain, menuType);
        this.price = price;
        this.productNumber = productNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getProductNumber() {
        return productNumber;
    }
}
