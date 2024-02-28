package footballmanager.league;

import footballmanager.teams.Team;
import footballmanager.teams.TeamFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class League {
    String name;
    int amountMaxParticipants;
    ArrayList<Team> participants;
    LinkedHashMap<Team,TeamLeagueStadistics> teamsStadistics;
    ArrayList<Partit> partits;

    public League(String name, int amountMaxParticipants) {
        this.name = name;
        this.amountMaxParticipants = amountMaxParticipants;
        this.participants = new ArrayList<>();
        this.teamsStadistics = new LinkedHashMap<>();
        this.partits = new ArrayList<>();
    }

    public void addTeam(Team team){
        participants.add(team);
        TeamLeagueStadistics stadistics = LeagueFactory.newTeamStadistics(team);
        teamsStadistics.put(team,stadistics);
    }

    public boolean areAvailableParticipants(){
            if(amountMaxParticipants >= participants.size()){
                return true;
            }else{
                return false;
            }
    }

    public void printClassificacio(){
        this.toString();
    }

    public void disputarLliga(){

    }

    private void crearPartits(){

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
