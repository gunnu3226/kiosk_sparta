package model;

import java.util.List;

public class ResisterMenu {

    public static void resisterMenu(List<Menu> menuList) {
        menuList.add(new Menu("Burger", "비프버거",1));
        menuList.add(new Menu("Frozen Custard", "아이스크림",2));
        menuList.add(new Menu("Drinks", "음료",3));
    }

    public static void resisterProduct(List<Product> productList) {
        productList.add(new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, 1,1));
        productList.add(new Product("SmokeBurger", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, 1,2));
    }
}
