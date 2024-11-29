package view;

import enumerate.event.BadgeEvent;
import handler.OutputHandler;
import message.OutputMessage;
import model.Order;
import model.Reservation;
import service.EventService;

import static enumerate.event.EventValue.*;
import static enumerate.menu.Menu.CHAMPAGNE;
import static message.OutputMessage.*;

public class Output {
    private final OutputHandler outputHandler;
    private final Reservation reservation;
    private final EventService eventService;

    public Output(OutputHandler outputHandler, Reservation reservation, EventService eventService) {
        this.outputHandler = outputHandler;
        this.reservation = reservation;
        this.eventService = eventService;
    }

    public void printResult() {
        printHeader();
        printOrderMenu();
        printTotalPriceBeforeEvent();
        printGift();
        printEventList();
        printTotalEventPrice();
        printTotalPriceAfterEvent();
        printBadge();
    }

    private void printHeader() {
        System.out.println(outputHandler.getHeaderMessage(reservation.getVisitMonth(), reservation.getVisitDay()));
        System.out.println();
    }

    private void printOrderMenu() {
        System.out.println(HEADER_ORDER_MENU.get());
        for (Order order : reservation.getOrders()) {
            String message = outputHandler.getNoticeMenuMessage(order.getMenuName(), order.getQuantity());

            System.out.println(message);
        }
        System.out.println();
    }

    private void printTotalPriceBeforeEvent() {
        System.out.println(HEADER_TOTAL_PRICE_BEFORE_EVENT.get());

        int total = reservation.totalOrderPrice();
        System.out.println(outputHandler.getNoticePriceMessage(total));
        System.out.println();
    }

    private void printGift() {
        System.out.println(HEADER_GIFT.get());

        if (eventService.isConditionGift()) {
            System.out.println(outputHandler.getNoticeMenuMessage(CHAMPAGNE.getName(), GIFT_VALUE.get()));
            System.out.println();
            return;
        }
        System.out.println(NOTICE_NO_EVENT.get());
        System.out.println();
    }

    private void printEventList() {
        System.out.println(HEADER_TOTAL_EVENT.get());

        if (eventService.getChristmasDayEventPrice() != NO_EVENT_VALUE.get()) {
            System.out.println(outputHandler.getNoticeEventMessage(EVENT_NAME_HRISTMAS_DAY, eventService.getChristmasDayEventPrice()));
        }
        if (reservation.getTotalWeekEventPrice() != NO_EVENT_VALUE.get() && !reservation.getWeekEventKind().equals(NOTICE_NO_EVENT)) {
            System.out.println(outputHandler.getNoticeEventMessage(reservation.getWeekEventKind(), reservation.getTotalWeekEventPrice()));
        }
        if (reservation.getSpecialEventPrice() != NO_EVENT_VALUE.get()) {
            System.out.println(outputHandler.getNoticeEventMessage(EVENT_NAME_SEPECIAL, SPECIAL_DISCOUNT_VALUE.get()));
        }
        if (eventService.isConditionGift()) {
            System.out.println(outputHandler.getNoticeEventMessage(EVENT_NAME_GIFT, GIFT_DISCOUNT_VALUE.get()));
        }
        System.out.println();
    }

    private void printTotalEventPrice() {
        System.out.println(HEADER_TOTAL_EVENT_PRICE.get());
        System.out.println(outputHandler.getNoticeEventPriceMessage(eventService.totalEventPrice()));
        System.out.println();
    }

    private void printTotalPriceAfterEvent() {
        System.out.println(HEADER_TOTAL_PRICE_AFTER_EVENT.get());
        System.out.println(outputHandler.getNoticePriceMessage(eventService.totalPrice()));
        System.out.println();
    }

    private void printBadge() {
        System.out.println(HEADER_BADGE.get());
        System.out.println(BadgeEvent.getBadgeName(eventService.totalEventPrice()));
    }
}
