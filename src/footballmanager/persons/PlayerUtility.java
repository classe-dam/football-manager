package footballmanager.persons;

import footballmanager.teams.Team;

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

    public static Player takePlayerFromArrayPlayers(ArrayList<Player> players){
        Iterator<Player> playersIterator = players.iterator();
        while(playersIterator.hasNext()){
            System.out.println("player");
        }
        return null;
    }
}
