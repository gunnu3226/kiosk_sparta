package model;

import java.util.List;
import java.util.Map;

public class Menu {

    private String menuName;
    private String menuExplain;
    private int menuType;


    public Menu(String menuName, String menuExplain, int menuType) {
        this.menuName = menuName;
        this.menuExplain = menuExplain;
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuExplain() {
        return menuExplain;
    }

    public int getMenuType() {
        return menuType;
    }
}
