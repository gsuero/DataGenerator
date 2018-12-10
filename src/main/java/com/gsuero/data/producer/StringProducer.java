package com.gsuero.data.producer;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.StringColumn;

public class StringProducer extends VisitorAdapter {

    public StringProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        StringColumn col = (StringColumn) column;
        context.appendData(col.getValue());
        setValue(col.getName(), col.getValue());
    }
}
