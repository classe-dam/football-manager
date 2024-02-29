package footballmanager.league;

import footballmanager.teams.Team;
import footballmanager.teams.TeamUtility;
import footballmanager.utils.TeclatUtils;
import footballmanager.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;

public class LeagueFactory {
    public static League newLeague(ArrayList<Team> teams){
        String leagueName = TeclatUtils.getStringInput("which is the league name");
        int amountTeams = TeclatUtils.getInputInt("how many teams do you want the league have",2,teams.size());
        return new League(leagueName,amountTeams);
    }

    public static TeamLeagueStadistics newTeamStadistics(){
        return new TeamLeagueStadistics();
    }
    public static void fillLeagueTeams(ArrayList<Team> teams, League league){
        int availableSpots = league.amountMaxParticipants - league.participants.size();
        int usedSpots = 0;
        HashSet<Team> selectedTeams = new HashSet<>();
        boolean exit = false;
        boolean keepAdding = true;
        do{
            keepAdding = TeclatUtils.getBoolean("Do you wanna add more teams?");
            if(keepAdding){
                Team team = TeamUtility.getExistingTeam("wich team do you wanna add by team name",teams);
                if(selectedTeams.contains(team)){
                    Utils.printRed("Team is already in the league");
                }else{
                    selectedTeams.add(team);
                    league.addTeam(team);
                    usedSpots += 1;
                    Utils.printGreen("Team added correctly");
                };

            }
            if(selectedTeams.size() < 2 && !keepAdding){
                Utils.printRed("enter at least 2 teams");
            }
            if((!keepAdding && selectedTeams.size() >= 2) || usedSpots >= availableSpots){
                exit = true;
            }
        }while(!exit);
    }
}
