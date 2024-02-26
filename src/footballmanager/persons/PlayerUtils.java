package footballmanager.persons;

import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class PlayerUtils {
    public static void printPlayersArrayToBeChoosen(ArrayList<Player> peopleArray){
        for ( Player person : peopleArray){
            printIfTransferible(person);
        }
    }

    public static boolean personArrayContainsPersonId(ArrayList<Player> playerArray, int personId){
        for ( Player person : playerArray){
            if (person.getPersonaId() == personId){
                return true;
            }
        }
        return false;
    }

    private  static void printIfTransferible(Player person){
        if (person.esTransferible()){
            System.out.println("id: " + person.getPersonaId() +" name: " + person.getNom() + " cognom: " + person.getCognom());
        }
    }
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

    public static Player takePlayerFromArrayPeople(ArrayList<Player> people, int personId){
        Iterator<Player> playersIterator = people.iterator();
        while(playersIterator.hasNext()){
            Player person = playersIterator.next();
            if(person.getPersonaId() == personId){
                playersIterator.remove();
                return person;
            }
        }
        return null;
    }

    public static Player choosePlayerFromPlayersArray(ArrayList<Player> playerArray){
        System.out.println("wich available player do you wanna transfer to the team");

        PlayerUtils.printPlayersArrayToBeChoosen(playerArray);
        int choosenPlayer = 0;
        boolean validPlayer = false;
        do {
            try{
                choosenPlayer = TeclatUtils.getInputInt("plese choose one player by id: ",1);
                boolean containsValue = PlayerUtils.personArrayContainsPersonId(playerArray,choosenPlayer);
                if(containsValue){
                    validPlayer = true;
                    System.out.println("existing Player good");
                }else{
                    System.out.println("please choose an existing Player");
                }
            }catch(Exception err){
                System.out.println("error checking value from iterator");
            }
        }while(!validPlayer);

        return PlayerUtils.takePlayerFromArrayPeople(playerArray, choosenPlayer);
    }

}
