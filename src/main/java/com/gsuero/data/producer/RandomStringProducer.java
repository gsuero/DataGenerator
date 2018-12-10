package com.gsuero.data.producer;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.RandomStringColumn;
import com.gsuero.data.factory.StringFactory;

public class RandomStringProducer extends VisitorAdapter {

    public RandomStringProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        RandomStringColumn col = (RandomStringColumn) column;
        String value = StringFactory.generate(col.getFormat());
        context.appendData(value);
        setValue(col.getName(), value);
    }
}
