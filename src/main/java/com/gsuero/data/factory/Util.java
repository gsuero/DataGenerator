package com.gsuero.data.factory;

import java.util.List;
import java.util.Random;

public class Util {
    
    private static Random random = new Random();
    
    static int getRandomNumber(int min, int max) {
        return random.ints(min, max).limit(1).findFirst().getAsInt();
    }

    static boolean isIn(int chance) {
        if (chance == 0) {
            return true;
        } else if (chance == 100) {
            return false;
        }

        int number = getRandomNumber(0, 99);
        return number > chance;
    }
    
    static String getRandomFrom(List<String> values) {
        return values.get(getRandomNumber(0, values.size()));
    }
}
