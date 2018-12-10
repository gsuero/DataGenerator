package com.gsuero.data;

import java.io.IOException;

import com.gsuero.data.column.BaseColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gsuero
 */
public abstract class VisitorAdapter implements Visitor {
    protected Context context;
    protected static final Logger logger = LoggerFactory.getLogger(VisitorAdapter.class);
    abstract public void visit(BaseColumn column) throws IOException;

    public VisitorAdapter(Context context) {
        super();
        this.context = context;
    } 
    public void visitEnter(BaseColumn column) throws IOException {
        if (context.getColumnIndex() > 0) {
            context.append(context.getDelimiter());
        }
    }

    public void visitLeave(BaseColumn column) throws IOException {
        context.incrementColumnIndex();
    }
    
    protected void setValue(String name, String value) {
        context.getColumnValues().put(name, value);
    }

    

}
