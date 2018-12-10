package com.gsuero.data.factory;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang.RandomStringUtils.randomAscii;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

/**
 * Utility class for string generation.
 * @author gsuero
 */
public class StringFactory {
    
    /**
     * Randomize a set of characters based on a format template. <br />
     *  Format. ie: <strong>ddd****awww</strong> can generate <strong>018~<~<LBO1 </strong><br />
     *   <ul>
     *      <li>d: number</li><br />
     *      <li>*: anything in the ASCII table between 33 and 126 (inclusive), . (34 is avoided)</li><br />
     *      <li>a: characters</li><br />
     *      <li>w: alphanumeric</li><br />
     *   </ul>
     * @param Format.
     * @return String
     */
    public static String generate(String format) {
        final StringBuilder builder = new StringBuilder(format.length());
        format.chars().forEach(item -> {
            switch (item) {
                case 'd':
                    builder.append(randomNumeric(1));
                    break;
                case '*':
                    boolean invalid = true;
                    do {
                        char val = randomAscii(1).charAt(0);
                        if (val != 32 && val != 34) { // avoid space and quote
                            builder.append(val);
                            invalid = false;
                        }
                    } while (invalid);
                    break;
                case 'a':
                    builder.append(randomAlphabetic(1));
                    break;
                case 'w':
                    builder.append(randomAlphanumeric(1));
                    break;
                default: 
                    builder.append(item);
            }
        });

        return builder.toString();
    }
}
