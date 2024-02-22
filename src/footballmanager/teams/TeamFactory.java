package footballmanager.teams;

import footballmanager.utils.TeclatUtils;

public class TeamFactory {

    public static Team createTeam(){
        String name = TeamUtility.GetUniqueEquipName();
        String ciutat = TeclatUtils.getStringInput("In wich city is the team located at");
        String date = TeclatUtils.getDate("At wich date was the team fundated?", 0, 2024);
        String nameEstadi = TeclatUtils.getOptionalStringInput(
                "do you wanna add the name of the stadium of the team?",
                "wich is the name of the stadium of the team?");
        String namePresident = TeclatUtils.getOptionalStringInput(
                "do you wanna add the name of the president of the team?",
                "wich is the name of the president of the team?");
        if(nameEstadi == null && namePresident == null){
            return new Team(name,ciutat,date);
        }else if(nameEstadi != null && namePresident != null){
            return new Team(name,ciutat,date, namePresident, 1);
        } else if (nameEstadi != null && namePresident == null) {
            return new Team(name,ciutat,date,nameEstadi,1);
        } else if (nameEstadi == null && namePresident != null) {
            return new Team(namePresident, nameEstadi, name,ciutat,date);
        }
        return null;
    }
}
