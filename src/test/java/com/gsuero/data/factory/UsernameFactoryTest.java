package com.gsuero.data.factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsernameFactoryTest {

    @Test
    public void generateBasedOnNames() {
        for (int a = 0; a < 5000; a++) {
            String username = UsernameFactory.generate(UsernameFactory.Base.NAME);
            assertTrue(String.format("Invalid generated username: %s", username), validateUserName(username));
        }
    }

    
    public static boolean validateUserName(final CharSequence cs) {
        if (cs == null) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(cs.charAt(i)) == false && cs.charAt(i) != '.' && cs.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }
}
