package enumerate.event;

import enumerate.menu.MenuGroup;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import static enumerate.event.EventConstant.NO_EVENT_VALUE;
import static enumerate.event.EventConstant.WEEK_DISCOUNT_VALUE;
import static enumerate.menu.MenuGroup.DESSERT;
import static enumerate.menu.MenuGroup.MAIN;
import static java.time.DayOfWeek.*;

public enum WeekEvent {
    WEEKDAY(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY), DESSERT, WEEK_DISCOUNT_VALUE.getValue()),
    WEEKEND(List.of(FRIDAY, SATURDAY), MAIN, WEEK_DISCOUNT_VALUE.getValue());

    private final List<DayOfWeek> dayOfWeeks;
    private final MenuGroup menuGroup;
    private final int value;

    WeekEvent(List<DayOfWeek> dayOfWeeks, MenuGroup menuGroup, int value) {
        this.dayOfWeeks = dayOfWeeks;
        this.menuGroup = menuGroup;
        this.value = value;
    }

    public static int getWeekEventPrice(DayOfWeek dayOfWeek, MenuGroup menuGroup) {
        return Arrays.stream(values())
                .filter(weekEvent -> weekEvent.dayOfWeeks.contains(dayOfWeek) && weekEvent.menuGroup.equals(menuGroup))
                .findAny()
                .map(weekEvent -> weekEvent.value)
                .orElse(NO_EVENT_VALUE.getValue());
    }

}
