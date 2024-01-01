package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static List<Product> products = new ArrayList<>();
    private static int waitingNumber = 1;

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static int getWaitingNumber() {
        return waitingNumber;
    }

    public static void setWaitingNumber(int waitingNumber) {
        Order.waitingNumber = waitingNumber;
    }

    public static void clearOrder() {
        products.clear();
    }
}
