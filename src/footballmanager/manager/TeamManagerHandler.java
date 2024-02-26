package footballmanager.manager;

import footballmanager.persons.*;
import footballmanager.teams.Team;
import footballmanager.teams.TeamUtility;
import footballmanager.utils.TeclatUtils;
import footballmanager.utils.Utils;

import java.util.ArrayList;


public class TeamManagerHandler {
    public static void removeTeam(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray, Team team){
        ArrayList<Player> players = team.getPlayers();
        peopleArray.addAll(players);
        teamsArray.remove(team);
        Utils.printGreen("Team removed correctly");
    }
    public static void modifyPresident(Team team){
        String newPresident = TeclatUtils.getStringInput("wich is the new president name");
        team.setPresesident(newPresident);
        Utils.printGreen("President modified correctly");
    }

    public static void destroyTrainer(Team team){
        team.removeTrainer();
        Utils.printGreen("Trained removed from team correctly");
    }

    public static void signPerson(ArrayList<Person> peopleArray, Team team){
        Person person = PersonUtils.choosePersonFromPersonsArray(peopleArray);

        if (person instanceof Player){
            Player player = (Player) person;
            PlayerUtils.validateCorrectDorsal(player,team);
            player.transferirAEquip(team);
            Utils.printGreen("Player signed correctly");
        }else if(person instanceof Trainer){
            Trainer trainer = (Trainer) person;
            Trainer oldTrainer = team.getTrainer();
            if(oldTrainer == null){
                team.setTrainer(trainer);
                Utils.printGreen("Trained signed correctly");
            }else{
                peopleArray.add(oldTrainer);
                team.setTrainer(trainer);
                Utils.printGreen("Trainer signed correctly and removed from team the trainer");
            }
        }
    }

    public static void transferPlayer(ArrayList<Team> teamsArray, Team team){
        ArrayList<Player> players = team.getPlayers();
        Player player = PlayerUtils.choosePlayerFromPlayersArray(players);
        Team newTeam = TeamUtility.getExistingTeam("wich team do you want to transfer the player to?", teamsArray);
        player.transferirAEquip(newTeam);
        Utils.printGreen("Player transfered correctly");
    }


}
