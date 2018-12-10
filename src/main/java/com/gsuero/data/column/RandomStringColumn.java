package com.gsuero.data.column;

/**
 * Generate a random string value from a given format
 * ie: ddd****awww can generate 018~<~<LBO1
 *   d number
 *   * anything in the ASCII table between 33 and 126 (inclusive), . (34 is avoided)
 *   a characters
 *   w alphanumeric
 * @author gsuero
 */
public class RandomStringColumn extends BaseColumn {
    private static final long serialVersionUID = -6188723670488779047L;
    private String format;
    
    public RandomStringColumn(String name, String format) {
        super(ColumnType.RANDOM_STRING);
        setName(name);
        this.format = format;
    }
    public RandomStringColumn() {
        super(ColumnType.RANDOM_STRING);
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
}
