package enumerate.menu;

import enumerate.menu.Menu;

import java.util.Arrays;
import java.util.List;

import static enumerate.menu.Menu.*;

public enum MenuGroup {
    APPETIZER(List.of(MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BARBECUE_RIB, SEAFOOD_PASTA, CHRISTMAS_PASTA)),
    DESSERT(List.of(CHOCOLATE_CAKE, ICE_CREAM)),
    BEVERAGE(List.of(ZERO_COLA, RED_WINE, CHAMPAGNE)),
    INVLID(null);

    private final List<Menu> menus;

    MenuGroup(List<Menu> menus) {
        this.menus = menus;
    }

    public static MenuGroup findMenuGroupByMenu(Menu menu) {
        return Arrays.stream(values())
                .filter(menuGroup -> menuGroup.equals(menu))
                .findFirst()
                .orElse(INVLID);
    }
}
