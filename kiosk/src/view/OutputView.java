package view;

import java.util.List;
import java.util.Map;
import model.Menu;
import model.Order;
import model.Product;

public class OutputView {

    public static void showMenuOrder(List<Menu> menuList) {
        String format = " %d. %-15s | %s";
        System.out.println();
        System.out.println("\" 건우의 Mcdonald's 에 오신걸 환영합니다.\"");
        System.out.println("  아래 메뉴판을 보시고 메뉴를 골라주세요.");
        System.out.println();
        System.out.println("      [Mcdonald's MENU ]");
        for(int i=0; i<menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.printf((format)+"%n",i+1, menu.getMenuName() , menu.getMenuExplain());
        }
        System.out.println();
        System.out.println("       [ ORDER MENU ]");
        System.out.printf((format)+"%n",menuList.size() + 1 ,"Order", "장바구니를 확인 후 주문합니다.");
        System.out.printf((format)+"%n",menuList.size() + 2 ,"Cancel", "진행중인 주문을 취소합니다.");
    }

    public static void showProductOrder(int menuType, List<Menu> menuList, List<Product> productList) {
        String format = "%d. %-20s | W %.1f | %s";
        System.out.println("\" 건우의 Mcdonald's 에 오신걸 환영합니다.\"");
        System.out.println("  아래 상품메뉴판을 보시고 상품을 골라주세요.");
        System.out.println();
        for(Menu menu : menuList) {
            if(menu.getMenuType() == menuType) {
                System.out.println("             [ "+menu.getMenuName()+" MENU ]");
            }
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMenuType() == menuType) {
                Product product = productList.get(i);
                System.out.printf((format)+"%n",product.getProductNumber() , product.getMenuName(), product.getPrice() ,product.getMenuExplain());
            }
        }
    }

    public static void confirmNoOptionOrder(Product product) {
        System.out.println("\"" + product.getMenuName() + "   | W " + product.getPrice() + " | "+ product.getMenuExplain());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
    }

    public static void showUserOption(Product product) {
        String format = " %-15s | W %.1f | %s";
        System.out.printf((format) + "%n",product.getMenuName(),product.getPrice(), product.getMenuExplain());
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        int optionIndex = 1;
        for(Map.Entry<String, Double> option : product.getOptions().entrySet()) {
            String formatOption = "%d. %s( W %.1f )";
            System.out.printf((formatOption)+"%n",optionIndex, option.getKey(), product.getPrice() + option.getValue());
            optionIndex++;
        }
    }

    public static void showTotalOrder(Order order) {
        String format = "%-20s | W %.1f | %d 개 | %s";
        double sum  = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for(Map.Entry<Product,Integer> map : order.getProducts().entrySet()) {
            Product product = map.getKey();
            System.out.printf((format)+"%n", product.getMenuName(), product.getPrice(), map.getValue(), product.getMenuExplain());
            sum += product.getPrice() * map.getValue();
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.1f",sum);
        System.out.println();
        System.out.println("1. 주문          2. 메뉴판");
    }

    public static void successAddOrder(Product product) {
        System.out.println(product.getMenuName() + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }
    public static void successOrder(Order order) {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + order.getWaitingNumber() + " ] 번 입니다.");
        for (int i = 3; i > 0; i--) {
            System.out.println("(" + i + "초후 메뉴판으로 돌아갑니다.)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void cancelConfirm() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
    }

    public static void viewTotalOrderList(Map<Product, Integer> totoalOrderList, double totalPrice) {
        String format = "- %-20s | %d개 | W %.1f ";
        System.out.println("**************관리자 모드**************");
        System.out.println("        [ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for(Map.Entry<Product,Integer> map : totoalOrderList.entrySet()) {
            System.out.printf((format) + "%n" ,map.getKey().getMenuName(),map.getValue(),map.getKey().getPrice());
        }
        System.out.println();
        System.out.println("        [ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W "+totalPrice + " ] 입니다.");
        System.out.println();
        System.out.println("**************관리자 모드**************");
        System.out.println("1. 돌아가기");
    }

    public static void showOrderCancle() {
        System.out.println("주문이 취소 되었습니다.");
        for (int i = 3; i > 0; i--) {
            System.out.println("(" + i + "초후 메뉴판으로 돌아갑니다.)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void invaildInput() {
        System.out.println("잘못된 입력입니다. 숫자를 다시 입력해 주세요.");
    }
}
