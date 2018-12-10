package com.gsuero.data.column;

/**
 * Blank columns to generate empty string
 * @author gsuero
 */
public class BlankColumn extends BaseColumn {
    private static final long serialVersionUID = 1635234635918269073L;

    public BlankColumn(String name) { 
        super(ColumnType.BLANK);
        setName(name);
    }
    
    public BlankColumn() {
        super(ColumnType.BLANK);
    }

    
}
