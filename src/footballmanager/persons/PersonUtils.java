package footballmanager.persons;

import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;
import java.util.Iterator;

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

    public static Person takePersonFromArrayPeople(ArrayList<Person> people, int personId){
        Iterator<Person> playersIterator = people.iterator();
        while(playersIterator.hasNext()){
            Person person = playersIterator.next();
            if(person.getPersonaId() == personId){
                playersIterator.remove();
                return person;
            }
        }
        return null;
    }

    public static Person choosePersonFromPersonsArray(ArrayList<Person> peopleArray, Team team){
        System.out.println("wich available player do you wanna transfer to the team");

        PersonUtils.printPeopleArrayToBeChoosen(peopleArray);
        int choosenPerson = 0;
        boolean validPerson = false;
        do {
            try{
                choosenPerson = TeclatUtils.getInputInt("plese choose one player by id: ",1);
                boolean containsValue = PersonUtils.personArrayContainsPersonId(peopleArray,choosenPerson);
                if(containsValue){
                    validPerson = true;
                    System.out.println("existing person good");
                }else{
                    System.out.println("please choose an existing person");
                }
            }catch(Exception err){
                System.out.println("error checking value from iterator");
            }
        }while(!validPerson);

        return PersonUtils.takePersonFromArrayPeople(peopleArray, choosenPerson);
    }
}
