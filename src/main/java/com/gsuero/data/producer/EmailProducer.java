package com.gsuero.data.producer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.gsuero.data.Context;
import com.gsuero.data.VisitorAdapter;
import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.EmailColumn;
import com.gsuero.data.factory.EmailAddressFactory;

public class EmailProducer extends VisitorAdapter {

    public EmailProducer(Context context) {
        super(context);
    }

    @Override
    public void visit(BaseColumn column) {
        EmailColumn col = (EmailColumn) column;
        String value;
        if (CollectionUtils.isNotEmpty(col.getFrom())) {
            value = EmailAddressFactory.fromList(col.getFrom());
        } else if (StringUtils.isNotBlank(col.getDomain())) {
            value = EmailAddressFactory.generateRandom(col.isNameBased(), col.getDomain());
        } else {
            value = EmailAddressFactory.generateRandom(col.isNameBased());
        }
        
        context.appendData(value);
        setValue(col.getName(), value);
    }
}
