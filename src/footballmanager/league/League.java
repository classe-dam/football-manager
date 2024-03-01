package footballmanager.league;

import footballmanager.teams.Team;

import java.util.*;

public class League {
    String name;
    int amountMaxParticipants;
    ArrayList<Team> participants;
    HashMap<Team, TeamLeagueStatistics> teamsStadistics;
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
        TeamLeagueStatistics stadistics = LeagueFactory.newTeamStadistics();
        teamsStadistics.put(team,stadistics);
    }

    public void printClassificacio(){
        //create array from the hashmap
        LinkedList<Map.Entry<Team, TeamLeagueStatistics>> list = new LinkedList<>(teamsStadistics.entrySet());

        // Sort the LinkedList
        Collections.sort(list, new Comparator<Map.Entry<Team, TeamLeagueStatistics>>() {
            @Override
            public int compare(Map.Entry<Team, TeamLeagueStatistics> o1, Map.Entry<Team, TeamLeagueStatistics> o2) {
                return Integer.compare(o2.getValue().getPoints(), o1.getValue().getPoints());
            }
        });

        // Print the sorted LinkedList
        int position = 1;
        for (Map.Entry<Team, TeamLeagueStatistics> entry : list) {
            //afegir lo de distingir per gols a favor el ordre
            Team team = entry.getKey();
            TeamLeagueStatistics statistics = entry.getValue();
            System.out.println(
                    position + " - " +
                            team.getName() +
                            " points: " + statistics.getPoints() +
                            " -- partitsDisputats " + statistics.getPlayedMatchesAmount() +
                            " -- counter goals/ favour goals " + statistics.getCounterGoals() + "/" + statistics.getFavourGoals()
            );
            position += 1;
        }
    }

    public void disputarLliga(){
        //create matches
        this.crearPartits();
        //play them
        this.disputarPartits();
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
        for (Match match : this.partits){
            match.playMatch();
        }
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
