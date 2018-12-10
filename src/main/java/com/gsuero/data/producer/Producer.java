package com.gsuero.data.producer;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.lang3.StringUtils;

import com.gsuero.data.Context;
import com.gsuero.data.Visitor;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.ColumnType;

//TODO ADD ValidatingVisitor pattern
public class Producer extends VisitorAdapter {
    private Map<String, BaseColumn> columns;
    private static Random r = new Random();
    private boolean headerLine = false;
    
    public Producer(Context context) {
        super(context);
    }

    public void produce() throws IOException {
        try { 
            if (headerLine) {
                String header = columns.keySet().stream().collect(Collectors.joining(String.valueOf(context.getDelimiter())));
                context.writer().write(header);
                context.writer().write(context.getLineSeparator());
            }
            for (int a = 0; a < context.getMaxRows(); a++) {
                getColumns().entrySet().stream().forEach(item -> item.getValue().accept(this));
            }
        } finally {
            context.writer().close();
        }

    }

    @Override
    public void visit(BaseColumn column) throws IOException {
        if (shouldContinueBasedOnNullProbability(column.getChance())) {
            produce(column).visit(column);
        } else {
            context.appendData(StringUtils.EMPTY);  
        }
    }

    @Override
    public void visitEnter(BaseColumn column) throws IOException {
        produce(column).visitEnter(column);
    }

    @Override
    public void visitLeave(BaseColumn column) throws IOException {
        produce(column).visitLeave(column);
        if (context.getColumnIndex() >= getColumns().size()) {
            String line = context.getLine().toString();
            if (context.isReferenceColumns()) {
                StrSubstitutor sub = new StrSubstitutor(context.getColumnValues());
                line = sub.replace(line);
            }
            reset();
            context.writer().write(line);
            context.writer().write(context.getLineSeparator());
        }

        context.writer().flush();
    }

    Visitor produce(BaseColumn column) {
        ColumnType type = column.getType();
        switch (type) {
            case BLANK:
                return new BlankProducer(context);
            case UUID:
                return new UUIDProducer(context);
            case LIST:
                return new ListProducer(context);
            case REFERENCE_COLUMN:
                return new ReferenceProducer(context);
            case DATE:
                return new DateProducer(context);
            case STRING:
                return new StringProducer(context);
            case RANDOM_STRING:
                return new RandomStringProducer(context);
            case EMAIL_ADDRESS:
                return new EmailProducer(context);
            default:
                throw new UnsupportedOperationException("Not implemented yet");

        }
    }

    private void reset() {
        context.resetColumnIndex();
        context.resetColumnValues();
        context.setReferenceColumns(false);
        context.resetLine();
    }
    
    public Map<String, BaseColumn> getColumns() {
        return columns;
    }
    public void setColumns(Map<String, BaseColumn> columns) {
        this.columns = columns;
    }
    
    static boolean shouldContinueBasedOnNullProbability(int chance) {
        if (chance == 0) {
            return true;
        } else if (chance == 100) { 
            return false;
        }
  
        int number = r.ints(0, 99).limit(1).findFirst().getAsInt();
        return number > chance;
    }

    public void setHeaderLine(boolean headerLine) {
        this.headerLine = headerLine;
    }
}

