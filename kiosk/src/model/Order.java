package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static List<Product> products = new ArrayList<>();
    private static int waitingNumber = 1;


    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void getProducts() {
        double sum  = 0;
        System.out.println("[ Orders ]");
        for(Product product : products) {
            System.out.print(product.getMenuName()+"    |");
            System.out.print(" W "+product.getPrice()+" |");
            System.out.print(" "+product.getMenuExplain());
            System.out.println();
            sum += product.getPrice();
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+sum);
    }

    public static void clearOrder() {
        products.clear();
    }

    public static int getWaitingNumber() {
        return waitingNumber;
    }

    public static void setWaitingNumber(int waitingNumber) {
        Order.waitingNumber = waitingNumber;
    }
}
