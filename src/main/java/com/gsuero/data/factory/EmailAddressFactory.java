package com.gsuero.data.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;

public class EmailAddressFactory {
    static List<String> domains;
    static Random random = new Random();

    static {
        try {
            domains = IOUtils.readLines(UsernameFactory.class.getClassLoader().getResourceAsStream("data/domains.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String fromList(List<String> emails) {
        return Util.getRandomFrom(emails);
    }
    public static String generateRandom(boolean nameBased) {
        String email = String.format("%s@%s", UsernameFactory.generate(nameBased ? UsernameFactory.Base.NAME : UsernameFactory.Base.RANDOM), Util.getRandomFrom(domains));
        return email;
    }
    
    public static String generateRandom(boolean nameBased, String domain) {
        String email = String.format("%s@%s", UsernameFactory.generate(nameBased ? UsernameFactory.Base.NAME : UsernameFactory.Base.RANDOM), domain);
        return email;
    }
    
    public static String getRandomDomain() {
        return Util.getRandomFrom(domains);
    }


    
}
