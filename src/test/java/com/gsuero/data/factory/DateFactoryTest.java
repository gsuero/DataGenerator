package com.gsuero.data.factory;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.Test;

public class DateFactoryTest {
    
    @Test
    public void randomDateBetweenTwoDates() {
        DateTime to = DateTime.now();
        DateTime from = DateTime.now().minusDays(10);
        DateTime generatedDate = DateFactory.randomDateBetweenTwoDates(from,  to);
        
        assertTrue("Date is past of date interval", generatedDate.isAfter(from.getMillis()));
        assertTrue("Date is after date interval", generatedDate.isBefore(to.getMillis()));
    }

    @Test
    public void randomBetweenNoWeekends() {
        DateTime to = DateTime.now();
        DateTime from = DateTime.now().minusDays(10);
        List<Integer> weekends = Arrays.asList(DateTimeConstants.SATURDAY, DateTimeConstants.SUNDAY);
        
        for (int a = 0; a < 20; a++) {
            DateTime generatedDate = DateFactory.randomBetweenNoWeekends(from,  to);
            assertFalse("Date is on the weekend", weekends.contains(generatedDate.getDayOfWeek()));
        }
    }
    
    @Test
    public void randomBetweenExcludingDays() {
        DateTime to = DateTime.now();
        DateTime from = DateTime.now().minusDays(10);
        List<Integer> randomDays = Arrays.asList(DateTimeConstants.SATURDAY, DateTimeConstants.MONDAY, DateTimeConstants.THURSDAY);
        for (int a = 0; a < 20; a++) {
            DateTime generatedDate = DateFactory.randomBetweenExcludingDays(from,  to, randomDays);
            assertFalse("Date is on the weekend", randomDays.contains(generatedDate.getDayOfWeek()));
        }
    }
    
    @Test
    public void getDateWithSpecificHour() {
        DateTime date = DateTime.now().minusDays(10);
        DateTime newDate = DateFactory.getDateWithSpecificHour(date, 02);
        assertTrue(newDate.getHourOfDay() == 02);
    }
}
