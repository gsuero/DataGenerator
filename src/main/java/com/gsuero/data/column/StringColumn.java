package com.gsuero.data.column;

/**
 * @author gsuero
 */
public class StringColumn extends BaseColumn {
    private static final long serialVersionUID = -6188723670488779047L;
    private String value;
    
    public StringColumn(String name, String value) {
        super(ColumnType.STRING);
        setName(name);
        this.value = value;
    }
    public StringColumn() {
        super(ColumnType.STRING);
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
