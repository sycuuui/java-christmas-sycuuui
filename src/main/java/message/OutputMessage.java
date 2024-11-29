package message;

public enum OutputMessage {
    HEADER("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    HEADER_ORDER_MENU("<주문 메뉴>"),
    HEADER_TOTAL_PRICE_BEFORE_EVENT("<할인 전 총주문 금액>"),
    HEADER_GIFT("<증정 메뉴>"),
    HEADER_TOTAL_EVENT("<혜택 내역>"),
    HEADER_TOTAL_EVENT_PRICE("<총혜택 금액>"),
    HEADER_TOTAL_PRICE_AFTER_EVENT("<<할인 후 예상 결제 금액>"),
    HEADER_BADGE("<12월 이벤트 배지>"),
    NOTICE_MENU("%s %d개"),
    NOTICE_EVENT("%s: %s"),
    NOTICE_PRICE("%s원"),
    NOTICE_EVENT_PRICE("-%s원"),
    EVENT_NAME_HRISTMAS_DAY("크리스마스 디데이 할인"),
    EVENT_NAME_WEEKDAY("평일 할인"),
    EVENT_NAME_WEEKEND("주말 할인"),
    EVENT_NAME_SEPECIAL("특별 할인"),
    EVENT_NAME_GIFT("증정 이벤트"),
    NOTICE_NO_EVENT("없음");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
