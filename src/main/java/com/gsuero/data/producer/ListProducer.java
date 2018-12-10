package com.gsuero.data.producer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomDataGenerator;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.ListColumn;

public class ListProducer extends VisitorAdapter {

    private final RandomDataGenerator randomDataGenerator;

    public ListProducer(Context context) {
        super(context);
        this.randomDataGenerator = new RandomDataGenerator(new JDKRandomGenerator());
    }

    @Override
    public void visit(BaseColumn column) {
        ListColumn col = (ListColumn) column;
        int max = CollectionUtils.size(col.getValues()) - 1;
        String value = max > 0 ? col.getValues().get(randomDataGenerator.nextInt(0, max)) : "";;
        context.appendData(value);
        setValue(col.getName(), value);
    }
}
