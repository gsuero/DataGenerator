package com.gsuero.data.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class UsernameFactory {

    static List<String> firstNames;
    static List<String> lastnames;
    static List<String> usernames;

    public static enum Base {
        NAME,
        RANDOM,
        USERNAME_LIST
    }

    static {
        try {
            firstNames = IOUtils.readLines(UsernameFactory.class.getClassLoader().getResourceAsStream("data/firstnames.txt"), StandardCharsets.UTF_8);
            lastnames = IOUtils.readLines(UsernameFactory.class.getClassLoader().getResourceAsStream("data/lastnames.txt"), StandardCharsets.UTF_8);
            usernames = IOUtils.readLines(UsernameFactory.class.getClassLoader().getResourceAsStream("data/usernames.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generate(Base type) {
        switch (type) {
            case RANDOM:
                return generateRandomBasicUsername();
            case NAME:
                return generateBasedOnNames();
            case USERNAME_LIST:
                return Util.getRandomFrom(usernames);
            default:
                throw new UnsupportedOperationException("Not yet supported");
        }

    }

    private static String generateRandomBasicUsername() {
        return StringFactory.generate("aaaawwwwadd");
    }

    private static String generateBasedOnNames() {
        String firstName = Util.getRandomFrom(firstNames);
        String lastname = Util.getRandomFrom(lastnames);
        String username = String.format("%s%s%s%d",
                Util.isIn(20) ? firstName.substring(0, 1) : firstName,
                Util.isIn(30) ? "." : "",
                lastname,
                Util.isIn(50) ? Util.getRandomNumber(1, 90) : 455);
        return StringUtils.lowerCase(Normalizer.normalize(username, Normalizer.Form.NFD)).replaceAll("\\s+|'+","");
    }
}
