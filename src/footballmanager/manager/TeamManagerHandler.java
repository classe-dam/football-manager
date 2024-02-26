package footballmanager.manager;

import footballmanager.persons.Person;
import footballmanager.persons.PersonUtils;
import footballmanager.persons.Player;
import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;
import java.util.Iterator;


public class TeamManagerHandler {
    public static void removeTeam(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray, Team team){
        ArrayList<Player> players = team.getPlayers();
        peopleArray.addAll(players);
        teamsArray.remove(team);
    }
    public static void modifyPresident(Team team){
        String newPresident = TeclatUtils.getStringInput("wich is the new president name");
        team.setPresesident(newPresident);
    }

    public static void destroyTrainer(Team team){
        team.removeTrainer();
    }

    public static void  signPerson(ArrayList<Person> peopleArray, Team team){
        System.out.println("wich available player do you wanna transfer to the team");

        PersonUtils.printPeopleArrayToBeChoosen(peopleArray);

        boolean validPerson = false;
        do {
            try{
                int choosenPerson = TeclatUtils.getInputInt("plese choose one player by id: ",1);
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

    }

    public static void transferPlayer(ArrayList<Team> teamsArray, Team team){

    }


}
