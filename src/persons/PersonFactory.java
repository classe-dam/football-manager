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
        String birthDate = TeclatUtils.getStringInput("Player birthDate:");
        double sou = TeclatUtils.getInputDouble("Wich will be the player salary",0);
        boolean transferible = TeclatUtils.getBoolean("Is player transferible? true/false");
        int dorsal = TeclatUtils.getInputInt("Which will be the player number", 1, 99);
        Player.Posicio position = TeclatUtils.getPlayerPosition();

        return new Player(name,surname,birthDate, sou, transferible, dorsal, position);
    }


//    Player.Posicio posicio
    public static Person newTrainer(){
        return null;
    }
}
