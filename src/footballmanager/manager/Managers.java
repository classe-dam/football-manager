package footballmanager.manager;

import footballmanager.persons.Person;
import footballmanager.teams.Team;
import footballmanager.utils.TeclatUtils;

import java.util.ArrayList;

public class Managers {
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
                    PolitecnicsManagerHandler.veureClassificacioLliga();
                    break;
                case 2:
                    PolitecnicsManagerHandler.gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    PolitecnicsManagerHandler.nouEquip(teamsArray);
                    break;
                case 4:
                    PolitecnicsManagerHandler.newPerson(peopleArray);
                    break;
                case 5:
                    PolitecnicsManagerHandler.consultarEquip(teamsArray);
                    break;
                case 6:
                    PolitecnicsManagerHandler.consultarPersona(teamsArray);
                    break;
                case 7:
                    PolitecnicsManagerHandler.novaLliga();
                    break;
                case 8:
                    PolitecnicsManagerHandler.realitzarEntrenament();
                    break;
            }
        }while(!exit);
    }

//    {"Sortir","Donar de baixa equip","Modificar president/a","Destituir entrenador/a",
//            "Fitxar jugador/a o entrenador/a","Fitxar jugador/a o entrenador/a"
//    };
    public static void initTeamManager(ArrayList<Team> teamsArray, ArrayList<Person> peopleArray, Team team){
        boolean exit = false;
        do {
            int choosenQuestion = TeclatUtils.getOptionChosenByUser("Welcome to Team Manager",preguntas_team_manager);
            switch(choosenQuestion){
                case 0:
                    exit = true;
                    break;
                case 1:
                    PolitecnicsManagerHandler.veureClassificacioLliga();
                    break;
                case 2:
                    PolitecnicsManagerHandler.gestionarEquip(teamsArray, peopleArray);
                    break;
                case 3:
                    PolitecnicsManagerHandler.nouEquip(teamsArray);
                    break;
                case 4:
                    PolitecnicsManagerHandler.newPerson(peopleArray);
                    break;
                case 5:
                    PolitecnicsManagerHandler.consultarEquip(teamsArray);
                    break;
            }
        }while(!exit);
    }
}
