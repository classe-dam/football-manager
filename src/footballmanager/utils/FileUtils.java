package footballmanager.utils;

import footballmanager.persons.Player;
import footballmanager.teams.Team;

import java.io.BufferedWriter;
import java.util.ArrayList;

public class FileUtils {
    public static String removePathInvalidChars(String path) {
        String validCharsRegex = "[^a-zA-Z0-9-_rda]";

        return path.replaceAll(validCharsRegex, "");
    }

    public static String generateTeamFileData(Team team){
        return "team" + ";" +
                team.getName() + ";" +
                team.getPresident() + ";" +
                team.getNomEstadi() + ";" +
                team.getAnyFundacio() + ";" +
                team.getCiutat();
    }

    public static String generatePlayerFileData(Player player){
        return "player" + ";" +
                player.getPersonaId() + ";" +
                player.getNom() + ";" +
                player.getCognom() + ";" +
                player.getDataNaix() + ";" +
                player.getNivellMotivacio() + ";" +
                player.getPuntuacio() + ";" +
                player.getSou() + ";" +
                player.isTransferible() + ";" +
                player.getDorsal() + ";" +
                player.getPosicio();
    }

    public static String insertPlayersDataIntoFile(Team team, BufferedWriter bw){
        ArrayList<Player> players = team.getPlayers();
        for (Player player : players){
            try {
                String data = generatePlayerFileData(player);
                bw.write(data);
                bw.write(System.lineSeparator());
            }catch(Exception err){
                Utils.printRed("Player with id"
                        + player.getPersonaId()
                        + "could not be transfered, err:"
                        + err
                );
            }


        }
        return "";
    }
}
