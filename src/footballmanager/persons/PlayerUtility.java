package footballmanager.persons;

import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class PlayerUtility {
    public static int generatePlayerHashCode(int dorsal, String name){
        return  Objects.hash(name + dorsal);
    }

    public static void printJugadorsAmbElSeuDorsal(ArrayList<Player> players){
        Iterator<Player> playersIterator = players.iterator();;
        while (playersIterator.hasNext()){
            Player player = playersIterator.next();
            System.out.println("dorsal: " + player.getDorsal() + " player name: " + player.getNom());
        }
    }

    public static void validateCorrectDorsal(Player player, Team team){
        int dorsal = player.getDorsal();
        while(team.isDorsalUsed(dorsal)){
            dorsal = TeclatUtils.getInputInt("the dorsal " + dorsal + " is used in the team " + team.getName() + " please choose a new dorsal not used in the new team",1,100);
        }
        player.setDorsal(dorsal);
    }

}
