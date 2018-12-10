package com.gsuero.data.producer;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.DateColumn;
import com.gsuero.data.factory.DateFactory;
import com.gsuero.data.factory.Days;

public class DateProducer extends VisitorAdapter {
    
    public DateProducer(Context context) {
        super(context);
    }

    private static final int YEARS_IN_PAST = 50;
    

    @Override
    public void visit(BaseColumn column) {
        DateColumn col = (DateColumn) column;

        if (col.getMin() == null) {
            col.setMin(DateTime.now().minusYears(YEARS_IN_PAST));
        }
        if (col.getMax() == null) {
            col.setMax(DateTime.now());
        }
        DateTime value;
        if (CollectionUtils.isNotEmpty(col.getExcludeDays())) {
            List<Integer> days = col.getExcludeDays().stream().map(Days::getValue).collect(Collectors.toList());
            value = DateFactory.randomBetweenExcludingDays(col.getMin(), col.getMax(), days);
        } else {
            value = DateFactory.randomDateBetweenTwoDates(col.getMin(), col.getMax());
        }
        if (col.getFixedHour() != null && col.getFixedHour() > -1) {
            value = DateFactory.getDateWithSpecificHour(value, col.getFixedHour().intValue());
        }
        
        String val = StringUtils.isBlank(col.getFormat()) ? value.toString() : value.toString(col.getFormat());
        context.appendData(val);
        setValue(column.getName(), val);
    }
}
