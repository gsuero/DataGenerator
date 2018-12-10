package com.gsuero.data.factory;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringFactoryTest {

    @Test
    public void generate() {
        String numbers = StringFactory.generate("dddddd"); // numbers only
        assertTrue(StringUtils.isNumeric(numbers));
        
        String ascii = StringFactory.generate("******"); // ascii only
        assertTrue(StringUtils.isAsciiPrintable(ascii));
        
        String characters = StringFactory.generate("aaaaaaa"); // characters only
        assertTrue(StringUtils.isAlpha(characters));
        
        String alphanumeric = StringFactory.generate("wwwwwww"); // alphanumeric only
        assertTrue(StringUtils.isAlphanumeric(alphanumeric));
    }

    @Test
    public void generate_Random() {
        String random = StringFactory.generate("dd**aaww");
        assertNotNull(random);
        assertTrue(StringUtils.isNumeric(random.subSequence(0, 1)));
        assertTrue(StringUtils.isAsciiPrintable(random.subSequence(2, 3)));
        assertTrue(StringUtils.isAlpha(random.subSequence(4, 5)));
        assertTrue(StringUtils.isAlphanumeric(random.subSequence(6, 7)));
        
    }
}
