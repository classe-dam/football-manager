package utils;

import equips.Equip;
import persons.Player;

public class TeclatUtils {

    public static int getInputInt(String message, int min, int max) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        int input;
        do {
            input = Teclat.llegirInt();
            if (input >= min && input <= max) {
                chosenCorrectly = true;
            } else {
                System.out.println("The input need to be between " + min + " and " + max);
            }
        } while (!chosenCorrectly);

        return input;
    }

    public static double getInputDouble(String message, double min) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        double input;
        do {
            input = Teclat.llegirInt();
            if (input >= min) {
                chosenCorrectly = true;
            } else {
                System.out.println("The input need to be at least " + min);
            }
        } while (!chosenCorrectly);

        return input;
    }

    public static boolean getBoolean(String message){
        System.out.println(message);
        return Teclat.llegirBoolean();
    }

    public static Player.Posicio getPlayerPosition(){
            System.out.println("Enter the player position (POR, DEF, MIG, DAY):");
            int input = getOptionChosenByUser("", new String[]{"DEF","POR",  "MIG", "DAV"});
            switch (input) {
                case 0:
                    return Player.Posicio.DEF;
                case 1:
                    return Player.Posicio.POR;
                case 2:
                    return Player.Posicio.MIG;
                case 3:
                    return Player.Posicio.DAV;
                default:
                    return null;
            }
    }

    public static double getInputDouble(String message, double min, double max) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        double input;
        do {
            input = Teclat.llegirInt();
            if (input >= min && input <= max) {
                chosenCorrectly = true;
            } else {
                System.out.println("The input need to be between " + min + " and " + max);
            }
        } while (!chosenCorrectly);

        return input;
    }


    public static String getStringInput(String message){
        System.out.println(message);
        return Teclat.llegirString();
    }

    public static int getOptionChosenByUser(String titleMessage, String[] options) {
        int indexChosen;
        boolean chosenCorrectly = false;

        //print title
        System.out.println(titleMessage);

        //show options
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " - " + options[i]);
        }

        indexChosen = getInputInt("", 0, options.length - 1);

        return indexChosen;
    }

}
