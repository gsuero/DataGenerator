package com.gsuero.data;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * Context for the produce engine of data.
 * @author gsuero
 *
 */
//TODO implement writter as a component, and take out of context.
public class Context {
    private OutputStreamWriter output;
    private Long rows = Long.valueOf(0);
    private int columnIndex = 0;
    private int maxRows;
    private char delimiter = ',';
    private String lineSeparator = System.getProperty("line.separator");
    private BufferedWriter writer = null;
    private StringBuilder line = new StringBuilder();
    private boolean referenceColumns = false;
    
    private Map<String, String> columnValues = new HashMap<>();
    
    public BufferedWriter writer() {
        if (writer == null) {
            writer = new BufferedWriter(output);
        }
        return writer;
    }
    public Context append(String data) {
        line.append(data);
        return this;
    }
    public Context appendData(String data) {
        line.append("\"").append(data).append("\"");
        return this;
    }
    public void append(char data) {
        line.append(data);
    }
    public StringBuilder getLine() {
        return line;
    }
    public void resetLine() {
        line = new StringBuilder();
    }
    public void resetColumnIndex() {
        this.columnIndex = 0;
    }
    public void resetColumnValues() {
        columnValues = new HashMap<>();
    }
    
    /**
     * Output stream for the produced data.
     * @param output
     */
    public void setOutput(OutputStreamWriter output) {
        this.output = output;
    }
    public Long getRows() {
        return rows;
    }
    public void setRows(Long rows) {
        this.rows = rows;
    }
    public void incrementRows() {
        this.rows++;
    }
    public int getColumnIndex() {
        return columnIndex;
    }
    public void incrementColumnIndex() {
        this.columnIndex++;
    }
    public int getMaxRows() {
        return maxRows;
    }
    /**
     * Total rows
     * @param maxRows
     */
    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }
    public char getDelimiter() {
        return delimiter;
    }
    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
    public String getLineSeparator() {
        return lineSeparator;
    }
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
    public Map<String, String> getColumnValues() {
        return columnValues;
    }
    public boolean isReferenceColumns() {
        return referenceColumns;
    }
    public void setReferenceColumns(boolean referenceColumns) {
        this.referenceColumns = referenceColumns;
    }
    
}
