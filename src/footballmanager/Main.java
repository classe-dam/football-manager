package footballmanager;

import footballmanager.league.League;
import footballmanager.manager.Managers;
import footballmanager.persons.*;
import footballmanager.teams.Team;
import footballmanager.utils.DataUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();
        ArrayList<Team> teamsArray = new ArrayList<>();
        DataUtils.loadValues(peopleArray,teamsArray);
        Managers.initPolitecnicsManager(teamsArray,peopleArray);
    }
}
