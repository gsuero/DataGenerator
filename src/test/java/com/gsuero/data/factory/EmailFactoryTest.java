package com.gsuero.data.factory;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;

public class EmailFactoryTest {
    EmailValidator validator = EmailValidator.getInstance();
    
    @Test
    public void randomEmail() {
        String email = EmailAddressFactory.generateRandom(false);
        assertTrue("Invalid email address: "+ email, validator.isValid(email));
        
        String nameBasedEmail = EmailAddressFactory.generateRandom(false);
        assertTrue("Invalid email address: "+ nameBasedEmail, validator.isValid(nameBasedEmail));
    }
    
    @Test
    public void randomEmail_withDomain() {
        String email = EmailAddressFactory.generateRandom(true, "garissuero.me");
        assertTrue("Invalid email address: "+ email, validator.isValid(email));
        
        String nameBasedEmail = EmailAddressFactory.generateRandom(false, "garissuero.me");
        assertTrue("Invalid email address: "+ nameBasedEmail, validator.isValid(nameBasedEmail));
    }
    
    @Test
    public void randomEmail_withList() {
        String email = EmailAddressFactory.fromList(Arrays.asList("garis.suero@epsilon.com", "achandrakar@epsilon.com", "atineograciano@epsilon.com", "contact@garissuero.me"));
        assertTrue("Invalid email address: "+ email, validator.isValid(email));
        
        String invalidEmail = EmailAddressFactory.fromList(Arrays.asList("garis.suero@epsilon", "achandrakar", "@epsilon.com", "garissuero.me"));
        assertFalse("Expected invalid email address, found valid email address: "+ invalidEmail, validator.isValid(invalidEmail));
    }
}
