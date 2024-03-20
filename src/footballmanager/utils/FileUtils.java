package footballmanager.utils;

import footballmanager.teams.Team;

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
}
