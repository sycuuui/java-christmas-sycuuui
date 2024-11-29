package handler;

import message.OutputMessage;

import static message.OutputMessage.*;

public class OutputHandler {
    private String changeNumberFormat(int value) {
        return String.format("%,d", value);
    }

    public String getHeaderMessage(int month, int day) {
        return String.format(HEADER.get(), month, day);
    }

    public String getNoticeMenuMessage(String name, int quantity) {
        return String.format(NOTICE_MENU.get(), name, changeNumberFormat(quantity));
    }

    public String getNoticeEventMessage(OutputMessage eventName, int eventPrice) {
        return String.format(NOTICE_EVENT.get(), eventName.get(), getNoticeEventPriceMessage(eventPrice));
    }

    public String getNoticePriceMessage(int price) {
        return String.format(NOTICE_PRICE.get(), changeNumberFormat(price));
    }

    public String getNoticeEventPriceMessage(int price) {
        return String.format(NOTICE_EVENT_PRICE.get(), changeNumberFormat(price));
    }
}
