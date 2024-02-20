package persons;

import utils.TeclatUtils;

public class PersonFactory {

    private static PersonFactory instance;

    private PersonFactory() {} // Private constructor to prevent instantiation

    public static PersonFactory getInstance() {
        if (instance == null) {
            instance = new PersonFactory();
        }
        return instance;
    }
    public static Person newPlayer(){
        String name = TeclatUtils.getStringInput("Player name:");
        String surname = TeclatUtils.getStringInput("Player surname:");
        String birthDate = TeclatUtils.getDate("Enter the player birthDate:", 1900, 2024);
        double salary = TeclatUtils.getInputDouble("Wich will be the player salary",0);
        boolean transferible = TeclatUtils.getBoolean("Is player transferible? true/false");
        int dorsal = TeclatUtils.getInputInt("Which will be the player number", 1, 99);
        Player.Posicio position = TeclatUtils.getPlayerPosition();
        return new Player(name,surname,birthDate, salary, transferible, dorsal, position);
    }


    public static Person newTrainer(){
            String name = TeclatUtils.getStringInput("Trainer name:");
            String surname = TeclatUtils.getStringInput("Trainer surname:");
            String birthDate = TeclatUtils.getDate("Enter the player birthDate:", 1900, 2024);
            double salary = TeclatUtils.getInputDouble("Wich will be the trainer salary",0);
            int numTornejosGuanyats = TeclatUtils.getInputInt("How many tournaments did the trainer won", 0);
            boolean seleccionadorNacional = TeclatUtils.getBoolean("is national selector?");
            return new Trainer(name, surname, birthDate, salary, numTornejosGuanyats, seleccionadorNacional);
    }
}


