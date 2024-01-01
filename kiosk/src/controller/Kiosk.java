package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Menu;
import model.Order;
import model.Product;
import model.ResisterMenu;
import view.InputView;
import view.OutputView;

public class Kiosk {
    private List<Menu> menuList;
    private List<Product> productList;
    private Map<Product, Integer> orderList;
    private Order order;
    private Map<Product, Integer> totalOrderList;
    private double totalPrice;

    public Kiosk() {
        menuList = new ArrayList<>();
        productList = new ArrayList<>();
        orderList = new HashMap<>();
        order = new Order(orderList,1);
        totalOrderList = new HashMap<>();
    }

    public void kioskStart() {
        inputData();
        showMenuInfo();
    }

    public void inputData() {
        //메뉴데이터 입력
        ResisterMenu.resisterMenu(menuList);
        //상품데이터 입력
        ResisterMenu.resisterProduct(productList);
    }

    public void showMenuInfo() {
        //메인 메뉴 페이지 사용자 입력받기
        int input = InputView.showMenuOrder(menuList);
        while (true) {
            if (1<=input && input <= menuList.size()) {
                showProductInfo(input);
                break;
            } else if (input == menuList.size() + 1) {
                doOrder();
                break;
            } else if (input == menuList.size() + 2) {
                cancelOrder();
                break;
            } else if (input == 0) {
                viewTotalPriceAndOrderList();
            }
            OutputView.invaildInput();
        }
    }

    public void showProductInfo(int menuType) {
        int input = InputView.getProductOrder(menuType, menuList, productList);
        //상품페이지 사용자 입력 받는 부분
        while (true) {
            for (Product product : productList) {
                if (input == product.getProductNumber() && menuType == product.getMenuType()) {
                    addOrder(product);
                    break;
                }
            }
            OutputView.invaildInput();
        }
    }

    public void addOrder(Product product) {
        int input = InputView.addOrder(product);
        while (true) {
            if (input == 1) {
                OutputView.successAddOrder(product);
                order.addProduct(product);
                showMenuInfo();
                break;
            } else if (input == 2) {
                showProductInfo(product.getMenuType());
                break;
            }
            OutputView.invaildInput();
        }
    }

    public void doOrder() {
        int input = InputView.getOrderConfirm(order);
        while (true) {
            if (input == 1) {
                for(Map.Entry<Product, Integer> map : order.getProducts().entrySet()) {
                    totalOrderList.put(map.getKey(), map.getValue());
                    totalPrice += map.getKey().getPrice() * map.getValue();
                }
                order.clearOrder();
                OutputView.successOrder(order);
                order.setWaitingNumber(order.getWaitingNumber() + 1);

                showMenuInfo();
                break;
            } else if (input == 2) {
                showMenuInfo();
                break;
            }
            OutputView.invaildInput();
        }
    }

    public void cancelOrder() {
        int input = InputView.getCancelConfirm();
        while (true) {
            if (input == 1) {
                order.clearOrder();
                showMenuInfo();
                break;
            } else if (input == 2) {
                showMenuInfo();
                break;
            }
            OutputView.invaildInput();
        }
    }

    public void viewTotalPriceAndOrderList() {
        OutputView.viewTotalOrderList(totalOrderList, totalPrice);
        int input = InputView.getUserInput();
        while(true) {
            if(input == 1) {
                showMenuInfo();
                break;
            } else {
                OutputView.invaildInput();
            }
        }
    }
}
