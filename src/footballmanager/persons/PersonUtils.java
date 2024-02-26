package footballmanager.persons;

import java.util.ArrayList;

public class PersonUtils {
    public static void printPeopleArrayToBeChoosen(ArrayList<Person> peopleArray){
        for ( Person person : peopleArray){
            System.out.println("id: " + person.getPersonaId() +" name: " + person.getNom() + " cognom: " + person.getCognom());
        }
    }
    public static boolean personArrayContainsPersonId(ArrayList<Person> peopleArray, int personId){
        for ( Person person : peopleArray){
            if (person.getPersonaId() == personId){
                return true;
            }
        }
        return false;
    }
}
