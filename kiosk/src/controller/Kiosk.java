package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Menu;
import model.Order;
import model.Product;
import model.ResisterMenu;
import view.OutputView;

public class Kiosk {
    private static List<Menu> menuList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();


    public static void kioskStart() {
        initialize();
        mainMenuInfo();
    }

    public static void initialize() {
        ResisterMenu.resisterMenu(menuList);
        ResisterMenu.resisterProduct(productList);
    }
    public static void mainMenuInfo() {
        OutputView.mainMenuInfoOutput1(menuList);
        //메인페이지 사용자 입력받는 부분
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(!check) {
            int input = sc.nextInt();
            if(input== 1 || input == 2 || input == 3) {
                check = true;
                productMenuInfo(input);
            } else if(input == 4) {
                check = true;
                doOrder();
            } else if(input == 5) {
                check = true;
                //주문최소메서드
            } else {
                System.out.println("선택할 수 없는 옵션 메뉴 입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void productMenuInfo (int menuType) {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라주세요.");
        System.out.println();
        System.out.println("[ " + menuType + " MENU ]");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMenuType() == menuType) {
                Product product = productList.get(i);
                System.out.println(i + 1 + ". " + product.getMenuName() + "   | W " + product.getPrice() + " | "
                        + product.getMenuExplain());
            }
        }
        //상품페이지 사용자 입력 받는 부분
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(!false) {
            int input = sc.nextInt();
            for(Product product : productList) {
                if(input == product.getProductNumber()) {
                    check = true;
                    addOrder(product);
                }
            }
            System.out.println("존재하지 않는 메뉴입니다. 다시 입력해 주세요.");
        }
    }

    public static void addOrder(Product product) {
        System.out.println("\"" + product.getMenuName() + "   | W " + product.getPrice() + " | "+ product.getMenuExplain());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        boolean check = false;
        while(!check) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == 1) {
                System.out.println(product.getMenuName() + "가 장바구니에 추가되었습니다.");
                System.out.println();
                Order.addProduct(product);
                mainMenuInfo();
            }else if(input == 2) {
                productMenuInfo(product.getMenuType());
            }
        }
    }

    public static void doOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        Order.getProducts();
        System.out.println();
        System.out.println("1. 주문          2. 메뉴판");
        boolean check = false;
        while(!check) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == 1) {
                Order.clearOrder();
                System.out.println("주문이 완료되었습니다!");
                System.out.println();
                System.out.println("대기번호는 [ " +Order.getWaitingNumber() + " ] 번 입니다.");
                Order.setWaitingNumber(Order.getWaitingNumber()+1);

                for(int i=3; i>0; i--) {
                    System.out.println("("+i+"초후 메뉴판으로 돌아갑니다.)");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                mainMenuInfo();
            }else if(input == 2) {
                mainMenuInfo();
            }
        }
    }
}
