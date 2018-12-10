package com.gsuero.data.factory;

import java.util.Arrays;
import java.util.List;

public enum Days {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);
    int intvalue;

    Days(int value) {
        intvalue = value;
    }

    public static List<Days> weekends() {
        return Arrays.asList(SATURDAY, SUNDAY);
    }

    public static List<Days> weekdays() {
        return Arrays.asList(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
    }

    public int getValue() {
        return intvalue;
    }    
}
