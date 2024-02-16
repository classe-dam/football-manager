package persons;

public class PersonFactory {

    private static PersonFactory instance;

    private PersonFactory() {} // Private constructor to prevent instantiation

    public static PersonFactory getInstance() {
        if (instance == null) {
            instance = new PersonFactory();
        }
        return instance;
    }
    public Person createJugador(){
        return null;
    }

    public Person createEntrenador(){
        return null;
    }
}
