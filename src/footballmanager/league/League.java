package footballmanager.league;

import footballmanager.teams.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class League {
    String name;
    int amountMaxParticipants;
    ArrayList<Team> participants;
    HashMap<Team,TeamLeagueStadistics> teamsStadistics;
    ArrayList<Match> partits;

    public League(String name, int amountMaxParticipants) {
        this.name = name;
        this.amountMaxParticipants = amountMaxParticipants;
        this.participants = new ArrayList<>();
        this.teamsStadistics = new HashMap<>();
        this.partits = new ArrayList<>();
    }

    public void addTeam(Team team){
        participants.add(team);
        TeamLeagueStadistics stadistics = LeagueFactory.newTeamStadistics();
        teamsStadistics.put(team,stadistics);
    }

    public void printClassificacio(){
        this.toString();
    }

    public void disputarLliga(){
        //create matches
        this.crearPartits();
        //play them
    }

    private void crearPartits(){
        for (Team teamLocal : this.participants){
            for (Team teamVisitor : this.participants){
                if(!teamVisitor.equals(teamLocal)){
                    Match match = new Match(teamVisitor, teamLocal, this.teamsStadistics);
                    this.partits.add(match);
                }
            }
        }
    }

    private void disputarPartits(){

    }

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", amountMaxParticipants=" + amountMaxParticipants +
                ", participants=" + participants +
                ", teamsStadistics=" + teamsStadistics +
                ", partits=" + partits +
                '}';
    }
}
