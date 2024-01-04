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
        OutputView.showMenuOrder(menuList);
        //메인 메뉴 페이지 사용자 입력받기
        while (true) {
            int input = InputView.getUserInput();
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
        OutputView.showProductOrder(menuType, menuList, productList);
        //상품페이지 사용자 입력 받는 부분
        while (true) {
            int input = InputView.getUserInput();
            for (Product product : productList) {
                if (input == product.getProductNumber() && menuType == product.getMenuType()) {
                    chooseOption(product);
                    break;
                }
            }
            OutputView.invaildInput();
        }
    }

    public void chooseOption(Product product) {
        OutputView.showUserOption(product);
        int cntOption = 1;

        while (true) {
            int input = InputView.getUserInput();
            if(input == 1) {
                order.addProduct(product);
                showMenuInfo();
                break;
            } else if(1<input && input <= product.getOptions().size()) {
                for (Map.Entry<String,Double> option : product.getOptions().entrySet()) {
                    if(cntOption == input) {
                        order.addProduct(new Product(product.getMenuName()+"("+option.getKey()+")",product.getMenuExplain(),product.getMenuType(),product.getPrice()+option.getValue()));
                        showMenuInfo();
                        break;
                    }
                    cntOption++;
                }
            } else {
                OutputView.invaildInput();
                break;
            }
        }
    }

    public void doOrder() {
        OutputView.showTotalOrder(order);
        while (true) {
            int input = InputView.getUserInput();
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
        OutputView.cancelConfirm();
        while (true) {
            int input = InputView.getUserInput();
            switch (input) {
                case 1:
                    order.clearOrder();
                    showMenuInfo();
                    break;
                case 2:
                    showMenuInfo();
                    break;
                default:
                    OutputView.invaildInput();
            }
        }
    }

    public void viewTotalPriceAndOrderList() {
        OutputView.viewTotalOrderList(totalOrderList, totalPrice);
        while(true) {
            int input = InputView.getUserInput();
            if(input == 1) {
                showMenuInfo();
                break;
            } else {
                OutputView.invaildInput();
            }
        }
    }
}
