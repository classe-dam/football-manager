package footballmanager.teams;

import footballmanager.persons.Player;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;
import java.util.Iterator;

interface Executable {

}
public class TeamUtility {
    public static void printJugadorsAmbElSeuDorsal(Team team){
        System.out.println("Players of team: "+ team.getName());
        ArrayList<Player> players = team.getPlayers();
        Iterator<Player> playersIterator = players.iterator();;
        while (playersIterator.hasNext()){
            Player player = playersIterator.next();
            System.out.println("dorsal: " + player.getDorsal() + " player name: " + player.getNom());
        }
    }

    public static Team getTeam(String teamName, ArrayList<Team> teams){
        Iterator<Team> teamsIterator = teams.iterator();
        while(teamsIterator.hasNext()){
            Team team = teamsIterator.next();
            if(team.getName().equals(teamName)){
                return team;
            }
        }
        return null;
    }



    public static String GetUniqueEquipName(){
        boolean isUnique = false;
        String name;
        do {
            name = TeclatUtils.getStringInput("what is the title of the team");
            if(!Team.doesEquipExists(name)){
                isUnique = true;
            }else{
                System.out.println("the team name is already in use please provide a new name");
            }
        }while(!isUnique);
        return name;
    }

    public static Player getPlayerFromTeam(Team team, int hashcode){
        ArrayList<Player> players = team.getPlayers();
        Iterator<Player> playersIterator = players.iterator();
        while(playersIterator.hasNext()){
            Player player = playersIterator.next();
            if(player.equals(hashcode)){
                return player;
            }
        }
        return null;
    }

    public double calcularAveragePuntuationOfPlayers(){
        return 1;
    }

    public double calculateAverageMotivation(){
        return 0;
    }

    public static String GetExistantEquipName(){
        boolean exists = false;
        String name;
        do {
            name = TeclatUtils.getStringInput("what is the title of the team");
            if(Team.doesEquipExists(name)){
                exists = true;
            }else{
                System.out.println("the team with that name was not found please try with other name");
            }
        }while(!exists);
        return name;
    }
}
