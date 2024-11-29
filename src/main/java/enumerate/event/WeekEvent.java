package enumerate.event;

import enumerate.menu.MenuGroup;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static enumerate.event.EventValue.NO_EVENT_VALUE;
import static enumerate.event.EventValue.WEEK_DISCOUNT_VALUE;
import static enumerate.menu.MenuGroup.*;
import static java.time.DayOfWeek.*;

public enum WeekEvent {
    WEEKDAY(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY), DESSERT, WEEK_DISCOUNT_VALUE.get()),
    WEEKEND(List.of(FRIDAY, SATURDAY), MAIN, WEEK_DISCOUNT_VALUE.get()),
    INVALID(Collections.emptyList(),INVLID,NO_EVENT_VALUE.get());

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
                .orElse(NO_EVENT_VALUE.get());
    }

    public static WeekEvent getWeekEventKind(DayOfWeek dayOfWeek) {
        return Arrays.stream(values())
                .filter(weekEvent -> weekEvent.dayOfWeeks.contains(dayOfWeek))
                .findAny()
                .orElse(INVALID);
    }
}
