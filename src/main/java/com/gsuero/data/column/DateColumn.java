package com.gsuero.data.column;

import java.util.List;

import com.gsuero.data.factory.Days;
import org.joda.time.DateTime;

import com.gsuero.data.ErrorType;
import com.gsuero.data.ValidationError;

/**
 * Date columns to generate date in a given format.
 * @author gsuero
 */
public class DateColumn extends BaseColumn implements IValidatable {
    private static final long serialVersionUID = -6261604415492102701L;

    private DateTime min = null;
    private DateTime max = null;
    private String format = null;
    private List<Days> excludeDays;
    private Integer fixedHour = null;

    public DateColumn() {
        super(ColumnType.DATE);
    }

    public DateTime getMin() {
        return min;
    }

    public void setMin(DateTime min) {
        this.min = min;
    }

    public DateTime getMax() {
        return max;
    }

    public void setMax(DateTime max) {
        this.max = max;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
    public List<Days> getExcludeDays() {
        return excludeDays;
    }

    public void setExcludeDays(List<Days> excludeDays) {
        this.excludeDays = excludeDays;
    }

    public Integer getFixedHour() {
        return fixedHour;
    }

    public void setFixedHour(Integer fixedHour) {
        this.fixedHour = fixedHour;
    }

    @Override
    public void validate() {
        ValidationError errors =  new ValidationError();
        if (fixedHour != null && (fixedHour > 23 || fixedHour < 0)) {
            errors.add(ErrorType.LENGTH, "fixedHour", "If a fixed hour is provided it should be a valid integer between 0 and 23 (inclusive)");
        }
    }
}
