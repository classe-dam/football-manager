package footballmanager.league;

public class TeamLeagueStatistics {
    int playedMatchesAmount;
    int wonMatchesAmount;
    int losedMatchesAmount;
    int drawMatchesAmount;
    int favourGoals;
    int counterGoals;
    int points;
    TeamLeagueStatistics(){
        this.playedMatchesAmount = 0;
        this.favourGoals = 0;
        this.counterGoals = 0;
        this.points = 0;
    }


    public int getFavourGoals() {
        return favourGoals;
    }


    public int getCounterGoals() {
        return counterGoals;
    }

    public int getPlayedMatchesAmount() {
        return playedMatchesAmount;
    }

    public int getDifferenceGoals(){
        return this.counterGoals - this.favourGoals;
    }

    public int getPoints() {
        return points;
    }
    public void addWin(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.points += 3;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
        this.wonMatchesAmount +=1;
    }

    public void addDraw(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.points += 1;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
        this.drawMatchesAmount += 1;
    }

    public void addLose(int favourGoals, int counterGoals){
        this.playedMatchesAmount += 1;
        this.counterGoals += counterGoals;
        this.favourGoals += favourGoals;
        this.losedMatchesAmount +=1;
    }
}
