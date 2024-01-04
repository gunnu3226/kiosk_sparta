package model;

import java.util.Map;

public class Product extends Menu {
    private double price;
    private int productNumber;
    private Map<String,Double> options;

    public Product(String menuName, String menuExplain, double price, int menuType, int productNumber, Map<String,Double> options) {
        super(menuName, menuExplain, menuType);
        this.price = price;
        this.productNumber = productNumber;
        this.options = options;
    }

    public Product(String menuName, String menuExplain, int menuType, double price) {
        super(menuName, menuExplain, menuType);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public Map<String, Double> getOptions() {
        return options;
    }
}
