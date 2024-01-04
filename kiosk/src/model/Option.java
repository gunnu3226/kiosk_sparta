package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Option {

    private Map<String,Double> bugerOption;
    private Map<String,Double> snackOption;
    private Map<String,Double> drinksOption;


    public Option() {
        this.bugerOption = initBurgerOption();
        this.snackOption = initSnackOption();
        this.drinksOption = initDrinksOption();
    }

    private Map<String, Double> initBurgerOption() {
        Map<String, Double> options = new LinkedHashMap<>();
        options.put("onlyBurger", 0.0);
        options.put("set", 2.5);
        return options;
    }

    private Map<String, Double> initSnackOption() {
        Map<String, Double> options = new LinkedHashMap<>();
        options.put("2piece", 0.0);
        options.put("4piece", 1.0);
        return options;
    }

    private Map<String, Double> initDrinksOption() {
        Map<String, Double> options = new LinkedHashMap<>();
        options.put("Regular", 0.0);
        options.put("Large", 0.7);
        return options;
    }

    public Map<String, Double> getBurgerOption() {
        return bugerOption;
    }

    public Map<String, Double> getSnackOption() {
        return snackOption;
    }

    public Map<String, Double> getDrinksOption() {
        return drinksOption;
    }
}
