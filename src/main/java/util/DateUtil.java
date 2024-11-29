package util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {
    public static DayOfWeek DateToDayConverter(LocalDate date) {
        return date.getDayOfWeek();
    }
}
