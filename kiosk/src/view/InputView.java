package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Menu;
import model.Order;
import model.Product;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static int getUserInput() {
        System.out.println("원하는 번호를 입력해 주세요.");
        return sc.nextInt();
    }

}
