package footballmanager.league;

import footballmanager.teams.Team;

public class TeamLeagueStadistics {
    int playedMatchesAmount;
    int wonMatchesAmount;
    int losedMatchesAmount;
    int drawMatchesAmount;
    int favourGoals;
    int counterGoals;
    int points;
    TeamLeagueStadistics(){
        this.playedMatchesAmount = 0;
        this.favourGoals = 0;
        this.counterGoals = 0;
        this.points = 0;
    }

    public int getPlayedMatchEs() {
        return playedMatchesAmount;
    }


    public int getFavourGoals() {
        return favourGoals;
    }


    public int getCounterGoals() {
        return counterGoals;
    }


    public int getPoints() {
        return points;
    }
    public void addWin(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.points += 3;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
    }

    public void addDraw(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.points += 1;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
    }

    public void addLose(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
    }
}
