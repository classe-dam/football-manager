package footballmanager.utils;

import footballmanager.persons.Person;
import footballmanager.persons.Player;
import footballmanager.persons.Trainer;
import footballmanager.teams.Team;

import java.util.ArrayList;

public class DataUtils {
    public static void loadValues(ArrayList<Person> peopleArray, ArrayList<Team> teamsArray){
        Person player1 = new Player("player1","playersurname1","birthDate", 1000000, true, 5, Player.Posicio.DAV);
        Person player2 = new Player("player2","playersurname2","birthDate", 1000000, true, 6, Player.Posicio.DAV);
        Person player3 = new Player("player3","playersurname3","birthDate", 1000000, true, 7, Player.Posicio.DAV);
        Person trainer1 = new Trainer("trainer1","trainersurname3","birthDate", 10000, 5, true);
        Person trainer2 = new Trainer("trainer2","trainersurname3","birthDate", 10000, 2, false);
        Team team1 = new Team("team1","Barcelona","Date");
        Team team2 = new Team("team2","Texas","Date");
        team1.addPlayer((Player) player1);
        team1.addPlayer((Player) player2);
        team2.addPlayer((Player) player3);
        peopleArray.add(player1);
        peopleArray.add(player2);
        peopleArray.add(player3);
        peopleArray.add(trainer1);
        peopleArray.add(trainer2);
        teamsArray.add(team1);
        teamsArray.add(team2);
    };

}