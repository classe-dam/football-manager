package footballmanager.manager;

import footballmanager.persons.Person;
import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;

public class Manager {
    private static String[] preguntas_manager = {"Sortir","Veure classificació lliga","Gestionar equip","Donar d'alta equip",
            "Donar d'alta jugador/a o entrenador/a","Consultar dades equip","Consultar dades jugador/a",
            "Disputar nova lliga","Realitzar sessió entrenament"
    };

    private static String[] preguntas_team_manager = {"Sortir","Donar de baixa equip","Modificar president/a","Destituir entrenador/a",
            "Fitxar jugador/a o entrenador/a","Fitxar jugador/a o entrenador/a"
    };

    public static void initPolitecnicsManager(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray){
        boolean exit = false;
        do {
            int choosenQuestion = TeclatUtils.getOptionChosenByUser("Welcome to Politècnics Football Manager",preguntas_manager);
            switch(choosenQuestion){
                case 0:
                    exit = true;
                    break;
                case 1:
                    ManagerFunctions.veureClassificacioLliga();
                    break;
                case 2:
                    ManagerFunctions.gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    ManagerFunctions.nouEquip(teamsArray);
                    break;
                case 4:
                    ManagerFunctions.newPerson(peopleArray);
                    break;
                case 5:
                    ManagerFunctions.consultarEquip(teamsArray);
                    break;
                case 6:
                    ManagerFunctions.consultarPersona(teamsArray);
                    break;
                case 7:
                    ManagerFunctions.novaLliga();
                    break;
                case 8:
                    ManagerFunctions.realitzarEntrenament();
                    break;
            }
        }while(!exit);
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
                    ManagerFunctions.veureClassificacioLliga();
                    break;
                case 2:
                    ManagerFunctions.gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    ManagerFunctions.nouEquip(teamsArray);
                    break;
                case 4:
                    ManagerFunctions.newPerson(peopleArray);
                    break;
                case 5:
                    ManagerFunctions.consultarEquip(teamsArray);
                    break;
            }
        }while(!exit);
    }
}
