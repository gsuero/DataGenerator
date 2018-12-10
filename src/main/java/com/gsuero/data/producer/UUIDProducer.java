package com.gsuero.data.producer;

import java.util.UUID;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.UUIDColumn;

public class UUIDProducer extends VisitorAdapter {
    public UUIDProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        UUIDColumn col = (UUIDColumn) column;
        String uid = UUID.randomUUID().toString();
        if (!col.isUseDash()) {
            uid = uid.replaceAll("-", "");
        }
        String value = String.format("%s%s", col.getPrefix(), uid);
        context.appendData(value);
        setValue(column.getName(), value);
    }
}
