package footballmanager.utils;

import footballmanager.persons.Player;

public class TeclatUtils {

    public static int getInputInt(String message, int min, int max) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        int input = 0;
        do {
            try {
                input = Teclat.llegirInt();
                if (input >= min && input <= max) {
                    chosenCorrectly = true;
                } else {
                    System.out.println("The input need to be between " + min + " and " + max);
                }
            }catch(Exception err){
                System.out.println("number too big, please enter a smaller number");
            }

        } while (!chosenCorrectly);

        return input;
    }

    public static int getInputInt(String message, int min) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        int input = 0;
        do {
            try {
                input = Teclat.llegirInt();
                if (input >= min) {
                    chosenCorrectly = true;
                } else {
                    System.out.println("The input need to be between " + min);
                }
            }catch(Exception err){
                System.out.println("number too big, please enter a smaller number");
            }

        } while (!chosenCorrectly);

        return input;
    }

    public static double getInputDouble(String message, double min) {
        boolean chosenCorrectly = false;
        // print title
        System.out.println(message);

        //get input
        double input = 0;
        do {
            try {
                input = Teclat.llegirInt();
                if (input >= min) {
                    chosenCorrectly = true;
                } else {
                    System.out.println("The input need to be at least " + min);
                }
            }catch(Exception err){
                System.out.println("number too big, please enter a smaller number");
            }
        } while (!chosenCorrectly);

        return input;
    }

    public static String getDate(String title,int minYear, int maxYear){
        int day;
        int month;
        int year;
        year = getInputInt("Enter the year", minYear, maxYear);
        month = getInputInt("Enter the month", 1, 12);
        day = getInputInt("Enter the day", 1, 30);

        return day + "/" + month + "/" + year;
    }

    public static boolean getBoolean(String message){
        System.out.println(message);
        boolean correct = false;
        char letter;
        boolean value = false;

        do {
            System.out.println("choose between y/n");
            letter = Teclat.llegirChar();
            letter = Character.toUpperCase(letter);
            if (letter == 'Y'){
                value = true;
                correct = true;
            }else if(letter == 'N'){
                value = false;
                correct = true;
            }else{
                System.out.println("please choose a correct boolean");
            }
        }while (!correct);
        return value;
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
        double input = 0;
        do {
            try {

                input = Teclat.llegirInt();
                if (input >= min && input <= max) {
                    chosenCorrectly = true;
                } else {
                    System.out.println("The input need to be between " + min + " and " + max);
                }
            }catch(Exception err){
                System.out.println("number too big, please enter a smaller number");
            }
        } while (!chosenCorrectly);

        return input;
    }


    public static String getStringInput(String message){
        System.out.println(message);
        return Teclat.llegirString();
    }

    public static String getOptionalStringInput(String optionalMessage, String message){
        boolean userWants = getBoolean(optionalMessage);
        if(userWants){
            return getStringInput(message);
        }else{
            return null;
        }
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
