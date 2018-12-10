package com.gsuero.data.producer;


import org.apache.commons.lang3.StringUtils;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;

public class BlankProducer extends VisitorAdapter {

    public BlankProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        setValue(column.getName(), StringUtils.EMPTY);
    }
}
