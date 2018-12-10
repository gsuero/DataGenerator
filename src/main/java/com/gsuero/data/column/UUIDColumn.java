package com.gsuero.data.column;

import org.apache.commons.lang3.StringUtils;
/**
 * UUID columns to generate uuid's.
 * @author gsuero
 */
public class UUIDColumn extends BaseColumn {
    private static final long serialVersionUID = -6261604415492102701L;

    private boolean useDash = true;
    private String prefix = StringUtils.EMPTY;

    public UUIDColumn() {
        super(ColumnType.UUID);
    }
    
    public UUIDColumn(String name) {
        super(ColumnType.UUID);
        setName(name);
    }

    public UUIDColumn(boolean useDash, String prefix) {
        super(ColumnType.UUID);
        this.useDash = useDash;
        this.prefix = prefix;
    }

    public boolean isUseDash() {
        return useDash;
    }

    public void setUseDash(boolean useDash) {
        this.useDash = useDash;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
