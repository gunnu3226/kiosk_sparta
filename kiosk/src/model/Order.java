package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    private Map<Product, Integer> products;

    private int waitingNumber = 1;

    public Order(Map<Product,Integer> products, int waitingNumber) {
        this.products = products;
        this.waitingNumber = waitingNumber;
    }

    public void addProduct(Product product) {
        if(products.containsKey(product)){
            int num = products.get(product);
            products.put(product, num+1);
        }else {
            products.put(product, 1);
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    public void clearOrder() {
        products.clear();
    }
}
