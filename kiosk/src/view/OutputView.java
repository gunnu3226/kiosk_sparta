package view;

import java.util.List;
import model.Menu;

public class OutputView {

    public static void mainMenuInfoOutput1(List<Menu> menuList) {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU]");
        for(int i=0; i<menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println(i+1+". "+menu.getMenuName() + "   | " + menu.getMenuExplain());
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(menuList.size() + 1+". model.Order" + "  | 장바구니를 확인 후 주문합니다.");
        System.out.println(menuList.size()+ 2 +". Cancel" + "  | 진행중인 주문을 취소합니다.");
    }
}
