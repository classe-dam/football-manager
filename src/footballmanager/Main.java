package footballmanager;

import footballmanager.persons.*;
import footballmanager.teams.TeamFactory;
import footballmanager.teams.Team;
import footballmanager.teams.TeamUtility;
import footballmanager.utils.DataUtils;
import footballmanager.utils.TeclatUtils;
import footballmanager.utils.Utils;

import java.util.ArrayList;

public class Main {
    private static String[] preguntas_manager = {"Sortir","Veure classificació lliga","Gestionar equip","Donar d'alta equip",
            "Donar d'alta jugador/a o entrenador/a","Consultar dades equip","Consultar dades jugador/a",
            "Disputar nova lliga","Realitzar sessió entrenament"
    };

    private static String[] preguntas_team_manager = {"Sortir","Donar de baixa equip","Modificar president/a","Destituir entrenador/a",
            "Fitxar jugador/a o entrenador/a","Fitxar jugador/a o entrenador/a"
    };

    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();
        ArrayList<Team> teamsArray = new ArrayList<>();
        DataUtils.loadValues(peopleArray,teamsArray);
        initPolitecnicsManager(teamsArray,peopleArray);
    }

    public static void initPolitecnicsManager(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray){
        boolean exit = false;
        do {
            int choosenQuestion = TeclatUtils.getOptionChosenByUser("Welcome to Politècnics Football Manager",preguntas_manager);
            switch(choosenQuestion){
                case 0:
                    exit = true;
                    break;
                case 1:
                    veureClassificacioLliga();
                    break;
                case 2:
                    gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    nouEquip(teamsArray);
                    break;
                case 4:
                    newPerson(peopleArray);
                    break;
                case 5:
                    consultarEquip(teamsArray);
                    break;
                case 6:
                    consultarPersona(teamsArray);
                    break;
                case 7:
                    novaLliga();
                    break;
                case 8:
                    realitzarEntrenament();
                    break;
            }
        }while(!exit);
    }

    public static void veureClassificacioLliga(){

    }

    public static void gestionarEquip(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray){
        String teamName = TeclatUtils.getStringInput("wich equip do you wanna manage?");
        Team team = TeamUtility.getTeam(teamName, teamsArray);
        if(team != null){
          initTeamManager(teamsArray, peopleArray, team);
        }else{
            Utils.printRed("team does not exists please try again with a correct team");
        }
    }

    public static void initTeamManager(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray, Team team){
        boolean exit = false;
        do {
            int choosenQuestion = TeclatUtils.getOptionChosenByUser("Welcome to Team Manager",preguntas_team_manager);
            switch(choosenQuestion){
                case 0:
                    exit = true;
                    break;
                case 1:
                    veureClassificacioLliga();
                    break;
                case 2:
                    gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    nouEquip(teamsArray);
                    break;
                case 4:
                    newPerson(peopleArray);
                    break;
                case 5:
                    consultarEquip(teamsArray);
                    break;
            }
        }while(!exit);
    }

    public static void nouEquip(ArrayList<Team> teamsArray){
        Team newTeam =  TeamFactory.createTeam();
        System.out.println("new team data" + newTeam);
        teamsArray.add(newTeam);

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
            int playerHashcode = PlayerUtility.generatePlayerHashCode(dorsal, playerName);
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

    public static void novaLliga(){

    }

    public static void realitzarEntrenament(){

    }
}
