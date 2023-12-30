package controller;

import java.util.ArrayList;
import java.util.List;
import model.Menu;
import model.Order;
import model.Product;
import model.ResisterMenu;
import view.InputView;
import view.OutputView;
import view.SystemMessage;

public class Kiosk {
    private static List<Menu> menuList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    public static void kioskStart() {
        inputData();
        showMenuInfo();
    }

    public static void inputData() {
        //메뉴데이터 입력
        ResisterMenu.resisterMenu(menuList);
        //상품데이터 입력
        ResisterMenu.resisterProduct(productList);
    }

    public static void showMenuInfo() {
        //메인 메뉴 페이지 사용자 입력받기
        int input = InputView.getMenuOrder(menuList);
        while (true) {
            if (input == 1 || input == 2 || input == 3) {
                showProductInfo(input);
                break;
            } else if (input == 4) {
                doOrder();
                break;
            } else if (input == 5) {
                cancelOrder();
                break;
            }
            System.out.println(SystemMessage.INVAILD_INPUT);
        }
    }

    public static void showProductInfo(int menuType) {
        int input = InputView.getProductOrder(menuType, productList);
        //상품페이지 사용자 입력 받는 부분
        while (true) {
            for (Product product : productList) {
                if (input == product.getProductNumber() && menuType == product.getMenuType()) {
                    addOrder(product);
                    break;
                }
            }
            System.out.println(SystemMessage.INVAILD_INPUT);
        }
    }

    public static void addOrder(Product product) {
        int input = InputView.addOrder(product);
        while (true) {
            if (input == 1) {
                OutputView.successAddOrder(product);
                Order.addProduct(product);
                showMenuInfo();
                break;
            } else if (input == 2) {
                showProductInfo(product.getMenuType());
                break;
            }
            System.out.println(SystemMessage.INVAILD_INPUT);
        }
    }

    public static void doOrder() {
        int input = InputView.getOrderConfirm();
        while (true) {
            if (input == 1) {
                Order.clearOrder();
                OutputView.successOrder();
                Order.setWaitingNumber(Order.getWaitingNumber() + 1);
                showMenuInfo();
                break;
            } else if (input == 2) {
                showMenuInfo();
                break;
            }
        }
    }

    public static void cancelOrder() {
        int input = InputView.getCancelConfirm();
        while (true) {
            if (input == 1) {
                Order.clearOrder();
                showMenuInfo();
                break;
            } else if (input == 2) {
                showMenuInfo();
                break;
            }
        }
    }
}
