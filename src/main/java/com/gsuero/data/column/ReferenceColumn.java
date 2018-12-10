package com.gsuero.data.column;

import org.apache.commons.lang.StringUtils;

import com.gsuero.data.ErrorType;
import com.gsuero.data.ValidationError;

/**
 * Referemnce columns to use the value from a referenced column.
 * @author gsuero
 */
public class ReferenceColumn extends BaseColumn implements IValidatable {
    private static final long serialVersionUID = -6261604415492102701L;

    private String value = StringUtils.EMPTY;
    
    public ReferenceColumn() {
        super(ColumnType.REFERENCE_COLUMN);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void validate() {
        ValidationError errors = new ValidationError();
       if (StringUtils.isBlank(value)) {
           errors.add(ErrorType.BLANK, "value", "Value cannot be blank for a reference column");
       }
       
       if (!errors.isValid()) {
           //TODO
       }
    }
}
