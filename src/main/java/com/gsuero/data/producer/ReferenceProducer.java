package com.gsuero.data.producer;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.ReferenceColumn;

public class ReferenceProducer extends VisitorAdapter {

    public ReferenceProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        ReferenceColumn col = (ReferenceColumn) column;
        String value = String.format("${%s}", col.getValue());
        context.appendData(value);
        setValue(column.getName(), value);
        context.setReferenceColumns(true);
    }
}
