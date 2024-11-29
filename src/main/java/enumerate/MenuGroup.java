package enumerate;

import java.util.List;

import static enumerate.Menu.*;

public enum MenuGroup {
    APPETIZER(List.of(MUSHROOM_SOUP,TAPAS,CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK,BARBECUE_RIB,SEAFOOD_PASTA,CHRISTMAS_PASTA)),
    DESSERT(List.of(CHOCOLATE_CAKE,ICE_CREAM)),
    BEVERAGE(List.of(ZERO_COLA,RED_WINE,CHAMPAGNE));

    private final List<Menu> menus;

    MenuGroup(List<Menu> menus) {
        this.menus = menus;
    }
}
