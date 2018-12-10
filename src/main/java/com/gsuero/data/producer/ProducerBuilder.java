package com.gsuero.data.producer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import com.gsuero.data.Context;
import com.gsuero.data.column.BaseColumn;

public class ProducerBuilder {

    private int maxRows;
    private char delimiter = ',';
    private String lineSeparator = System.getProperty("line.separator");
    private String fileName;
    private OutputStreamWriter output;
    private Map<String, BaseColumn> columns = new LinkedHashMap<String, BaseColumn>();
    private boolean append = true;
    private boolean headers = false;
    
    public ProducerBuilder(int maxRows) {
        super();
        this.maxRows = maxRows;
    }

    public ProducerBuilder withHeaders(boolean headers) {
        this.headers = headers;
        return this;
    }
    public ProducerBuilder withLineSeparator(String separator) {
        this.lineSeparator = separator;
        return this;
    }
    public ProducerBuilder withAppend(boolean append) {
        this.append = append;
        return this;
    }
    public ProducerBuilder withDelimiter(char delimiter) {
        this.delimiter = delimiter;
        return this;
    }
    public ProducerBuilder withOutputStream(OutputStreamWriter writer) {
        this.output = writer;
        return this;
    }
    public ProducerBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
    public ProducerBuilder withColumns(Map<String, BaseColumn> columns) {
        this.columns = columns;
        return this;
    }
    
    public Producer build() throws IOException {
        Context context = new Context();
        context.setMaxRows(this.maxRows);
        if (output != null) {
            context.setOutput(this.output); 
        } else {
            context.setOutput(new FileWriter(this.fileName, this.append));
        }
        context.setDelimiter(this.delimiter);
        context.setLineSeparator(this.lineSeparator);
        Producer producer = new Producer(context);
        producer.setColumns(columns);
        producer.setHeaderLine(headers);
        return producer;
    }
}
