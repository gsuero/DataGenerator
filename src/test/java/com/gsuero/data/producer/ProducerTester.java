package com.gsuero.data.producer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import com.gsuero.data.column.BaseColumn;
import com.gsuero.data.column.DateColumn;
import com.gsuero.data.column.StringColumn;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

public class ProducerTester {

    public Producer setUp(OutputStreamWriter writer) throws Exception {
        Map<String, BaseColumn> columns = new LinkedHashMap<String, BaseColumn>();

        columns.put("name", new StringColumn("name", "garis"));
        DateColumn birthdate = new DateColumn();
        birthdate.setChance(1);
        birthdate.setFixedHour(6);
        birthdate.setMin(DateTime.now().minusYears(33));
        birthdate.setMax(DateTime.now().minusYears(32));
        birthdate.setName("birthdate");
        birthdate.setFormat("yyyy-MM-dd HH:mm:ss");
        columns.put("birthdate", birthdate);

        return new ProducerBuilder(10).withOutputStream(writer).withColumns(columns).build();
    }

    @Test
    public void produceCounts() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Producer producer = setUp(new OutputStreamWriter(output));
        producer.produce();
        String data = output.toString();
        String[] rows = data.split(System.getProperty("line.separator"));
        assertEquals("Expecting 10 rows", 10, rows.length);
        for (int a = 0; a < rows.length; a++) {
            String columns[] = rows[a].split(",");
            assertEquals("expecting 2 columns", 2, columns.length);
            assertTrue("name column is never empty", StringUtils.isNotBlank(columns[0]));
        }
    }
    
    @Test
    public void produceWithHeaders() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Producer producer = setUp(new OutputStreamWriter(output));
        producer.setHeaderLine(true);
        producer.produce();
        String data = output.toString();
        String[] rows = data.split(System.getProperty("line.separator"));
        assertEquals("Expecting 11 rows", 11, rows.length);
    }

    @Test
    public void shouldContinueBasedOnNullProbability() {
        int valueProcessed = 0;
        int percentage = 20;

        for (int a = 0; a < 10000; a++) {
            if (Producer.shouldContinueBasedOnNullProbability(percentage)) {
                valueProcessed++;
            }
        }
        assertTrue(String.format("Got %s processed", valueProcessed), valueProcessed > 7000 && valueProcessed < 9000);
    }

}
