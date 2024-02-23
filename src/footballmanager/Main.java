package footballmanager;

import footballmanager.manager.ManagerFunctions;
import footballmanager.persons.*;
import footballmanager.teams.Team;
import footballmanager.utils.DataUtils;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();
        ArrayList<Team> teamsArray = new ArrayList<>();
        DataUtils.loadValues(peopleArray,teamsArray);
        initPolitecnicsManager(teamsArray,peopleArray);
    }


}
