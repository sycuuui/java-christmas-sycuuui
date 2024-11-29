package enumerate.event;

public enum BadgeEvent {
    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000),
    NO_BADGE("없음",0);

    private final String name;
    private final int value;

    BadgeEvent(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getBadgeName(int price) {
        if(price > SANTA.value) {
            return SANTA.name;
        }
        if(price > TREE.value) {
            return TREE.name;
        }
        if(price > STAR.value) {
            return STAR.name;
        }
        return NO_BADGE.name;
    }
}
