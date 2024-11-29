package service;

import model.Reservation;

import java.time.LocalDate;

public class SaleService {
    private final Reservation reservation;
    private final LocalDate CHRISTMAS_DAY_SALE_STARTDATE = LocalDate.of(2024,12,1);
    private final LocalDate CHRISTMAS_DAY_SALE_FINISHDATE = LocalDate.of(2024,12,25);

    public SaleService(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isAvailableEvent() {

    }

    public int getChristmasDaySalePrice() {
        if(reservation.isRange(CHRISTMAS_DAY_SALE_STARTDATE,CHRISTMAS_DAY_SALE_FINISHDATE)) {
            return calculateChristmasDaySalePrice();
        }
        return 0;
    }

    private int calculateChristmasDaySalePrice() {
        int CHRISTMAS_DAY_SALE_STARTPRICE = 1000;
        int CHRISTMAS_DAY_SALE_UNIT = 100;
        int untilChristmasDate = reservation.calcaulateUntilChristmasDate(CHRISTMAS_DAY_SALE_STARTDATE);

        return CHRISTMAS_DAY_SALE_STARTPRICE + untilChristmasDate * CHRISTMAS_DAY_SALE_UNIT;
    }


}
