package model;

import java.util.List;

public class ResisterMenu {

    public static void resisterMenu(List<Menu> menuList) {
        menuList.add(new Menu("Burger", "버거",1));
        menuList.add(new Menu("Snack", "다양한 스낵",2));
        menuList.add(new Menu("Drinks", "커피",3));
    }

    public static void resisterProduct(List<Product> productList) {
        Option option = new Option();
        //menuType 1 : 햄버거메뉴
        productList.add(new Product("1955 Burger", "두툼한 순 쇠고기 패티, 특별한 1955 소스와 깊은 풍미의 그릴드 어니언까지", 6.4, 1,1,option.getBurgerOption()));
        productList.add(new Product("Big Mac", "100% 순 쇠고기 패티 두 장, 특별한 소스, 양상추, 치즈, 피클 양파까지 버거의 대명사", 5.5, 1,2, option.getBurgerOption()));
        productList.add(new Product("DoubleCheese Burger", "패티가 더블로 들어간 버거의 정석 치즈버거!", 4.7, 1,3, option.getBurgerOption()));
        productList.add(new Product("Bacon Tomato Deluxe", "순 쇠고기 패티에 베이컨, 토마토 양상추, 매콤달콤한 스위트 칠리소스를 더한 프리미엄 버거", 5.8, 1,4, option.getBurgerOption()));

        //menuType 2 : 스낵
        productList.add(new Product("Cheese Sticks","자연 모짜렐라 치즈로 빈틈없이 고소한 치즈스틱",2.0,2,1,option.getSnackOption()));
        productList.add(new Product("McNuggets","바삭하고 촉촉한 치킨이 한 입에 쏙!",1.6,2,2,option.getSnackOption()));
        productList.add(new Product("Hash Brown","씹으면 바삭바삭, 속은 부드러운 감자의 고소함",1.8,2,3,option.getSnackOption()));

        //menuType 3 : 커피메뉴
        productList.add(new Product("Americano", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!", 2.0, 3,1, option.getDrinksOption()));
        productList.add(new Product("(ICE) Americano", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!", 2.5, 3,2, option.getDrinksOption()));
        productList.add(new Product("CaffeLatte", "바로 내린 100%% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!", 3.0, 3,3, option.getDrinksOption()));
        productList.add(new Product("(ICE) CaffeLatte", "바로 내린 100%% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!", 3.5, 3,4, option.getDrinksOption()));
    }
}
//생성자 계속 선언하는 부분 생각해보기
