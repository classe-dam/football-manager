package footballmanager.league;

import footballmanager.teams.Team;
import footballmanager.utils.Utils;

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

        //is draw
        double randomNumberDraw = Utils.getRandomIntLimited(10);
        if(randomNumberDraw < 2){
            int goals = Utils.getRandomIntLimited(10);
            this.setDraw(goals);
        }
        int goalsWinner = Utils.getRandomIntLimited(10);
        int goalsLoser = Utils.getRandomIntLimited(goalsWinner);

        //if not draw who is winnint
        double randomNumber = Utils.getRandomIntLimited(10);
        if(randomNumber <= localMitjana){
            this.setWinner(this.local, goalsWinner, goalsLoser);
            this.setLoser(this.visitor, goalsWinner, goalsLoser);
        }else{
            this.setWinner(this.visitor, goalsWinner, goalsLoser);
            this.setLoser(this.local, goalsWinner, goalsLoser);
        }
    }

    private void setWinner(Team team, int goalsWinner, int goalsLoser){
        TeamLeagueStadistics stats = this.teamsStadistics.get(team);
        stats.addWin(goalsWinner, goalsLoser);
    }

    private void setLoser(Team team, int goalsWinner, int goalsLoser){
        TeamLeagueStadistics stats = this.teamsStadistics.get(team);
        stats.addLose(goalsLoser,goalsWinner);
    }

    private void setDraw(int goalsTeams){
        TeamLeagueStadistics statsVisitor = this.teamsStadistics.get(this.visitor);
        TeamLeagueStadistics statsLocal = this.teamsStadistics.get(this.local);
        statsVisitor.addDraw(goalsTeams, goalsTeams);
        statsLocal.addDraw(goalsTeams, goalsTeams);
    }

    private double getPlayerMitjanaStatsTotal(Team team){
        return team.calcularMitjanaMotivacio() + team.calcularMitjanaQualificacio();
    }
}
