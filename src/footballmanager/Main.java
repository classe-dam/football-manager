package footballmanager;

import footballmanager.persons.Player;
import footballmanager.persons.Trainer;
import footballmanager.teams.TeamFactory;
import footballmanager.teams.Team;
import footballmanager.persons.Person;
import footballmanager.persons.PersonFactory;
import footballmanager.teams.TeamUtility;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;

public class Main {
    private static String[] preguntas_manager = {"Sortir","Veure classificació lliga","Gestionar equip","Donar d'alta equip",
            "Donar d'alta jugador/a o entrenador/a","Consultar dades equip","Consultar dades jugador/a",
            "Disputar nova lliga","Realitzar sessió entrenament"
    };

    public static void loadValues(ArrayList<Person> peopleArray,ArrayList<Team> teamsArray){
        Person player1 = new Player("player1","playersurname1","birthDate", 1000000, true, 5, Player.Posicio.DAV);
        Person player2 = new Player("player2","playersurname2","birthDate", 1000000, true, 5, Player.Posicio.DAV);
        Person player3 = new Player("player3","playersurname3","birthDate", 1000000, true, 5, Player.Posicio.DAV);
        Person trainer1 = new Trainer("trainer1","trainersurname3","birthDate", 10000, 5, true);
        Person trainer2 = new Trainer("trainer2","trainersurname3","birthDate", 10000, 2, false);
        peopleArray.add(player1);
        peopleArray.add(player2);
        peopleArray.add(player3);
        peopleArray.add(trainer1);
        peopleArray.add(trainer2);
        Team team1 = new Team("team1","Barcelona","Date");
        Team team2 = new Team("team2","Texas","Date");
        teamsArray.add(team1);
        teamsArray.add(team2);
    };
    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();
        ArrayList<Team> teamsArray = new ArrayList<>();

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
                    gestionarEquip();
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
        }while(exit);
    }

    public static void veureClassificacioLliga(){

    }

    public static void gestionarEquip(){

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
            System.out.println("team does not exists please try again with a correct team");
        }
    }

    public static void consultarPersona(ArrayList<Team> teamsArray){
        String teamName = TeclatUtils.getStringInput("wich equip details do you wanna see?");
        boolean doesTeamExists = Team.doesEquipExists(teamName);
        if(doesTeamExists) {
            Team team = TeamUtility.getTeam(teamName, teamsArray);
        }else{
            System.out.println("team does not exists please try again with a correct team");
        }
    }

    public static void novaLliga(){

    }

    public static void realitzarEntrenament(){

    }
}
