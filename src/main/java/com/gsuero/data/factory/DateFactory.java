package com.gsuero.data.factory;

import java.util.List;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Utility class for generating dates
 * @author gsuero
 */
public class DateFactory {

    private static final RandomDataGenerator random = new RandomDataGenerator(new JDKRandomGenerator());
    DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss");

    /**
     * Generate a random date between two dates.
     * @param from
     * @param to
     * @return DateTime
     */
    public static DateTime randomDateBetweenTwoDates(DateTime from, DateTime to) {
        return new DateTime(randomBetween(from.getMillis(), to.getMillis()));
    }

    private static long randomBetween(long min, long max) {
        return random.nextLong(min, max);
    }

    
    /**
     * Random dates between two dates and excluding weekends
     * @param from DateTime
     * @param to DateTime
     * @return DateTime
     */
    public static DateTime randomBetweenNoWeekends(DateTime from, DateTime to) {
        boolean isWeekendDay = true;
        DateTime time;
        //VALIDATE the between dates are not 2 days apart. between sat and sun
        do {
            time = randomDateBetweenTwoDates(from, to);
            isWeekendDay = (time.getDayOfWeek() == DateTimeConstants.SATURDAY || time.getDayOfWeek() == DateTimeConstants.SUNDAY);
        } while (isWeekendDay);

        return time;
    }

    
    /**
     * Gets a random date between two dates excluding the provided day of the week
     * 
     *      MONDAY=1
     *      TUESDAY=2
     *      WEDNESDAY=3
     *      THURSDAY=4
     *      FRIDAY=5
     *      SATURDAY=6
     *      SUNDAY=7
     *      
     * @param from
     * @param to
     * @param days
     * @return
     */
    public static DateTime randomBetweenExcludingDays(DateTime from, DateTime to, List<Integer> days) {
        //TODO maybe remove depth...
        return randomBetweenExcludingDays(from, to, days, 50);
    }

    private static DateTime randomBetweenExcludingDays(DateTime from, DateTime to, List<Integer> days, int depth) {
        if (days == null || days.size() > 5 || depth <= 0) {
            return null;
        }
        DateTime time = randomDateBetweenTwoDates(from, to);
        if (days.contains(time.getDayOfWeek())) {
            //recursive call.
            return randomBetweenExcludingDays(from, to, days, --depth);
        }
        return time;
    }

    /**
     * Sets a date with an specific hour of the day. 
     * Note: minutes are kept.
     * @param date
     * @param fixedHour
     * @return
     */
    public static DateTime getDateWithSpecificHour(DateTime date, int fixedHour) {
        if (fixedHour > 23) {
            fixedHour = 23;
        }
        return date.withHourOfDay(fixedHour).withMinuteOfHour(random.nextInt(0, 59));
    }
}
