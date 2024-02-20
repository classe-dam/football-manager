import persons.Person;
import persons.PersonFactory;
import utils.TeclatUtils;

import java.util.ArrayList;

public class Main {
    private static String[] preguntas_manager = {"Sortir","Veure classificació lliga","Gestionar equip","Donar d'alta equip",
            "Donar d'alta jugador/a o entrenador/a","Consultar dades equip","Consultar dades jugador/a",
            "Disputar nova lliga","Realitzar sessió entrenament"
    };
    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();

        boolean exit = false;
        do {
            int choosenQuestion = TeclatUtils.getOptionChosenByUser("Welcome to Politècnics Football Manager",preguntas_manager);
            switch(choosenQuestion){
                case 0:
                    exit = true;
                case 1:
                    veureClassificacioLliga();
                case 2:
                    gestionarEquip();
                case 3:
                    nouEquip();
                case 4:
                    newPerson(peopleArray);
                case 5:
                    consultarEquip();
                case 6:
                    consultarPersona();
                case 7:
                    novaLliga();
                case 8:
                    realitzarEntrenament();
            }
        }while(exit);
    }

    public static void veureClassificacioLliga(){

    }

    public static void gestionarEquip(){

    }

    public static void nouEquip(){

    }

    public static void newPerson(ArrayList<Person> peopleArray){
        int personType = TeclatUtils.getOptionChosenByUser("Do you wanna add a player or traimer", new String[]{"Player","Trainer"});
        Person createdPerson;
        if (personType == 0){
            createdPerson = PersonFactory.newPlayer();
        }else{
            createdPerson = PersonFactory.newTrainer();
        }
        System.out.println("adding person" + createdPerson.toString());
        peopleArray.add(createdPerson);
    }

    public static void consultarEquip(){

    }

    public static void consultarPersona(){

    }

    public static void novaLliga(){

    }

    public static void realitzarEntrenament(){

    }
}
