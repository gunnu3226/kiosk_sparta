package view;

import java.util.List;
import java.util.Map;
import model.Menu;
import model.Order;
import model.Product;

public class OutputView {

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
    public static void viewTotalOrderList(Map<Product, Integer> totoalOrderList, double totalPrice) {
        String format = "- %-15s | %d개| W %.1f ";
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for(Map.Entry<Product,Integer> map : totoalOrderList.entrySet()) {
            System.out.printf((format) + "%n" ,map.getKey().getMenuName(),map.getValue(),map.getKey().getPrice());
        }
        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W"+totalPrice + " ] 입니다.");
        System.out.println();
        System.out.println("1. 돌아가기");
    }



    public static void invaildInput() {
        System.out.println(SystemMessage.INVAILD_INPUT);
    }
}
