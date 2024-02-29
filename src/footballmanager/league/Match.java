package footballmanager.league;

import footballmanager.teams.Team;

import java.util.HashMap;
import java.util.Random;

public class Match {
    Team visitor;
    Team local;
    int visitorGoals;
    int localGoals;
    Team matchWinner;
    HashMap<Team,TeamLeagueStadistics> teamsStadistics;

    public Match(Team visitor, Team local, HashMap<Team,TeamLeagueStadistics> teamsStadistics) {
        this.visitorGoals = 0;
        this.localGoals = 0;
        this.matchWinner = null;
        this.visitor = visitor;
        this.local = local;
        this.teamsStadistics = teamsStadistics;
    }

    public Team getVisitor() {
        return visitor;
    }

    public Team getLocal() {
        return local;
    }

    public int getVisitorGoals() {
        return visitorGoals;
    }

    public int getLocalGoals() {
        return localGoals;
    }

    public Team getMatchWinner() {
        return matchWinner;
    }

    public void playMatch(){
        double visitorMitjana = this.getPlayerMitjanaStatsTotal(this.visitor);
        double localMitjana = this.getPlayerMitjanaStatsTotal(this.local);
        double totalMitjana = visitorMitjana + localMitjana;

        Random random = new Random();
        double randomNumber = random.nextDouble(totalMitjana) + 1;
        if(randomNumber <= localMitjana){
            setWinner(local);
            setLoser(visitor);
        }else{
            setWinner(visitor);
            setLoser(local);
        }
    }

    private void setWinner(Team team){
        TeamLeagueStadistics stats = this.teamsStadistics.get(team);

    }

    private void setLoser(Team team){

    }

    private double getPlayerMitjanaStatsTotal(Team team){
        return team.calcularMitjanaMotivacio() + team.calcularMitjanaQualificacio();
    }
}
