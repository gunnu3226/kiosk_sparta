package view;

import java.util.List;
import model.Menu;
import model.Order;
import model.Product;

public class OutputView {

    public static void successAddOrder(Product product) {
        System.out.println(product.getMenuName() + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }
    public static void successOrder() {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + Order.getWaitingNumber() + " ] 번 입니다.");
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
}
