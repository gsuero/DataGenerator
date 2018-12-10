package com.gsuero.data.column;

import java.util.List;

/**
 * @author gsuero
 */
public class EmailColumn extends BaseColumn {
    private static final long serialVersionUID = -6188723670488779047L;
    private String domain;
    private boolean nameBased = true;
    private List<String> from;
    
    public EmailColumn(String name, boolean nameBased, String domain) {
        super(ColumnType.EMAIL_ADDRESS);
        setName(name);
        setNameBased(nameBased);
        setDomain(domain);
    }
    public EmailColumn() {
        super(ColumnType.STRING);
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public boolean isNameBased() {
        return nameBased;
    }
    public void setNameBased(boolean nameBased) {
        this.nameBased = nameBased;
    }
    public List<String> getFrom() {
        return from;
    }
    public void setFrom(List<String> from) {
        this.from = from;
    }
}
