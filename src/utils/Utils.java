package utils;

import persons.PersonFactory;

import java.util.Random;

public class Utils {
    private static Utils instance;

    private Utils() {};

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }
    public static double randomNumberBetween(double min, double max) {
        Random random = new Random();
        double randomNumber = min + (max - min) * random.nextDouble();
        // Round the random number to one decimal place
        return Math.round(randomNumber * 10.0) / 10.0;
    }

    public static int randomNumberBetween(int min, int max) {
        Random random = new Random();
        int randomNumber = min + (max - min) * random.nextInt();
        return Math.round(randomNumber * 10) / 10;
    }
}
