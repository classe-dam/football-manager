package footballmanager.manager;

import footballmanager.league.League;
import footballmanager.league.LeagueFactory;
import footballmanager.persons.Person;
import footballmanager.persons.PersonFactory;
import footballmanager.persons.Player;
import footballmanager.persons.PlayerUtils;
import footballmanager.teams.Team;
import footballmanager.teams.TeamFactory;
import footballmanager.teams.TeamUtility;
import footballmanager.utils.FileUtils;
import footballmanager.utils.TeclatUtils;
import footballmanager.utils.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class PolitecnicsManagerHandler {
    static League league = null;

    public static void nouEquip(ArrayList<Team> teamsArray){
        Team newTeam =  TeamFactory.createTeam();
        System.out.println("new team data" + newTeam);
        teamsArray.add(newTeam);
        Utils.printGreen("Team created correctly");
    }

    public static void newPerson(ArrayList<Person> peopleArray){
        int personType = TeclatUtils.getOptionChosenByUser("Do you wanna add a player or traimer", new String[]{"Player","Trainer"});
        Person createdPerson;
        if (personType == 0){
            createdPerson = PersonFactory.newPlayer();
        }else{
            createdPerson = PersonFactory.newTrainer();
        }
        System.out.println("adding person" + createdPerson.toString());
        peopleArray.add(createdPerson);
        Utils.printGreen("Person added correctly");
    }

    public static void consultarEquip(ArrayList<Team> teamsArray){
        String teamName = TeclatUtils.getStringInput("wich equip details do you wanna see?");
        boolean doesTeamExists = Team.doesEquipExists(teamName);
        if(doesTeamExists){
            Team team = TeamUtility.getTeam(teamName,teamsArray);
            System.out.println(team);
            TeamUtility.printJugadorsAmbElSeuDorsal(team);
        }else{
            Utils.printRed("team does not exists please try again with a correct team");
        }
    }

    public static void consultarPersona(ArrayList<Team> teamsArray){
        String teamName = TeclatUtils.getStringInput("wich equip details do you wanna see?");
        boolean doesTeamExists = Team.doesEquipExists(teamName);
        if(doesTeamExists) {
            Team team = TeamUtility.getTeam(teamName, teamsArray);
            int dorsal = TeclatUtils.getInputInt("Wich is the player dorsal???",1,100);
            String playerName = TeclatUtils.getStringInput("Wich is the player name???");
            int playerHashcode = PlayerUtils.generatePlayerHashCode(dorsal, playerName);
            Player player = TeamUtility.getPlayerFromTeam(team,playerHashcode);
            if(player != null){
                System.out.println(player);
            }else{
                Utils.printRed("player does not exists in that team");
            }
        }else{
            Utils.printRed("team does not exists please try again with a correct team");
        }
    }

    public static void novaLliga(ArrayList<Team> teamsArray){
        league = LeagueFactory.newLeague(teamsArray);
        Utils.printGreen("League created correctly now add the teams to it");
        System.out.println("Wich teams do you wanna add?");
        LeagueFactory.fillLeagueTeams(teamsArray, league);
        Utils.printGreen("Teams added correctly now lets play the league");
        //play league now
        league.disputarLliga();
        Utils.printGreen("Lliga disputada correctament");
    }

    public static void realitzarEntrenament(ArrayList<Person> peopleArray){
        for (Person person : peopleArray){
            person.entrenar();
        }
    }

    public static void veureClassificacioLliga(){
        if (league != null){
            league.printClassificacio();
        }else{
            Utils.printRed("You have to start the league before to see its classification");
        }
    }

    public static void gestionarEquip(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray){
        String teamName = TeclatUtils.getStringInput("wich equip do you wanna manage?");
        Team team = TeamUtility.getTeam(teamName, teamsArray);
        if(team != null){
            Managers.initTeamManager(teamsArray, peopleArray, team);
        }else{
            Utils.printRed("team does not exists please try again with a correct team");
        }
    }

    public static void loadTeams(ArrayList<Team> teamsArray){

    }

    public static void saveTeams(ArrayList<Team> teamsArray){
        String path = "data/" + FileUtils.removePathInvalidChars(TeclatUtils.getStringInput("Specifiy the filemame where the temas will be saved, without specifying the directory and the filee xtension")) + ".txt";
        Utils.printGreen("File will be saved on path " + path);

        BufferedWriter bw = null;
        try{
            File file = new File(path);

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Team team : teamsArray){
                String dataTeam = FileUtils.generateTeamFileData(team);
                bw.write(dataTeam);
                bw.write(System.lineSeparator());
            }
        }catch(Exception err){
            System.out.println("error saving teams" + err);
        }finally {
            try{
                bw.close();
            }catch(Exception e){
                System.out.println("Error closing the file");
            }
        }

    }

}
