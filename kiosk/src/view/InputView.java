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
        return sc.nextInt();
    }

}
