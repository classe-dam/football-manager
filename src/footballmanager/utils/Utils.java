package footballmanager.utils;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Random;

public class Utils {

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

    public static void printRed(String message) {
        // ANSI escape code for red color
        String ANSI_RED = "\u001B[31m";
        // ANSI escape code to reset color
        String ANSI_RESET = "\u001B[0m";

        // Print message in red
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void printGreen(String message) {
        // ANSI escape code for green color
        String ANSI_GREEN = "\u001B[32m";
        // ANSI escape code to reset color
        String ANSI_RESET = "\u001B[0m";

        // Print message in green
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }


}
