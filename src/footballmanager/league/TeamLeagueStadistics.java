package footballmanager.league;

import footballmanager.teams.Team;

public class TeamLeagueStadistics {
    int playedMatches;
    int favourGoals;
    int counterGoals;
    int points;
    TeamLeagueStadistics(){
        this.playedMatches = 0;
        this.favourGoals = 0;
        this.counterGoals = 0;
        this.points = 0;
    }

    public int getPlayedMatchEs() {
        return playedMatches;
    }

    public void addPlayedMatch() {
        this.playedMatches += 1;
    }

    public int getFavourGoals() {
        return favourGoals;
    }

    public void addFavourGoals(int favourGoals) {
        this.favourGoals += favourGoals;
    }

    public int getCounterGoals() {
        return counterGoals;
    }

    public void addCounterGoals(int counterGoals) {
        this.counterGoals += counterGoals;
    }

    public int getPoints() {
        return points;
    }
}
