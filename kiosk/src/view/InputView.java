package view;

import java.util.List;
import java.util.Scanner;
import model.Menu;
import model.Order;
import model.Product;

public class InputView {

    public static int getMenuOrder(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);

        System.out.println(SystemMessage.WELCOME_MESSAGE);
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU]");
        for(int i=0; i<menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println(i+1+". "+menu.getMenuName() + "   | " + menu.getMenuExplain());
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(menuList.size() + 1 +". Order" + "  | 장바구니를 확인 후 주문합니다.");
        System.out.println(menuList.size()+ 2 +". Cancel" + "  | 진행중인 주문을 취소합니다.");
        return sc.nextInt();
    }

    public static int getProductOrder(int menuType, List<Menu> menuList, List<Product> productList) {
        Scanner sc = new Scanner(System.in);
        System.out.println(SystemMessage.WELCOME_MESSAGE);
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라주세요.");
        System.out.println();
        for(Menu menu : menuList) {
            if(menu.getMenuType() == menuType) {
                System.out.println("[ "+menu.getMenuName()+" MENU ]");
            }
        }
        System.out.println("[ " + menuType + " MENU ]");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMenuType() == menuType) {
                Product product = productList.get(i);
                System.out.println(product.getProductNumber() + ". " + product.getMenuName() + "   | W " + product.getPrice() + " | "
                        + product.getMenuExplain());
            }
        }
        return sc.nextInt();
    }

    public static int addOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\"" + product.getMenuName() + "   | W " + product.getPrice() + " | "+ product.getMenuExplain());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        return sc.nextInt();
    }

    public static int getOrderConfirm() {
        Scanner sc = new Scanner(System.in);
        double sum  = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for(Product product : Order.getProducts()) {
            System.out.print(product.getMenuName()+"    |");
            System.out.print(" W "+product.getPrice()+" |");
            System.out.print(" "+product.getMenuExplain());
            System.out.println();
            sum += product.getPrice();
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+sum);
        System.out.println();
        System.out.println("1. 주문          2. 메뉴판");
        return sc.nextInt();
    }

    public static int getCancelConfirm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        return sc.nextInt();
    }
}
