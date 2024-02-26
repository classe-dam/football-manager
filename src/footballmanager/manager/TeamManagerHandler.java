package footballmanager.manager;

import footballmanager.persons.*;
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

    public static void signPerson(ArrayList<Person> peopleArray, Team team){
        Person person = PersonUtils.choosePersonFromPersonsArray(peopleArray, team);

        if (person instanceof Player){
            Player player = (Player) person;
            PlayerUtility.validateCorrectDorsal(player,team);
            player.transferirAEquip(team);
        }else if(person instanceof Trainer){
            Trainer trainer = (Trainer) person;
            Trainer teamTrainer = team.getTrainer();
            if(teamTrainer == null){
                team.setTrainer(trainer);
            }else{
                peopleArray.add(teamTrainer);
                team.setTrainer(trainer);
            }
        }
    }

    public static void transferPlayer(ArrayList<Team> teamsArray, Team team){

    }


}
