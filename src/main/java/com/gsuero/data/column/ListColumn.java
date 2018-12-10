package com.gsuero.data.column;

import java.util.ArrayList;
import java.util.List;

/**
 * List column to use a random value from a given list of values
 * @author gsuero
 */
public class ListColumn extends BaseColumn {
    private static final long serialVersionUID = 7011040108647749297L;
    private List<String> values = new ArrayList<>(); 

    public ListColumn() {
        super(ColumnType.LIST);
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
