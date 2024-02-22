package footballmanager.teams;

import footballmanager.persons.Player;
import footballmanager.persons.Trainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Team {
    public static HashSet<String> equipNames;
    private String president;
    private String nomEstadi;
    private String name;
    private String anyFundacio;
    private String ciutat;
    private HashSet<Integer> dorsalsUsats;
    private ArrayList<Player> players;
    private Trainer trainer;
    public static boolean doesEquipExists(String equipName){
        if(equipNames == null){
            equipNames = new HashSet<String>();
        }
        return equipNames.contains(equipName);
    }

    public static void addEquipExists(String equipName){
        if(equipNames == null){
            equipNames = new HashSet<String>();
        }
        equipNames.add(equipName);
    }

    public String getName() {
        return name;
    }

    public static HashSet<String> getEquipNames() {
        return equipNames;
    }

    public String getPresident() {
        return president;
    }

    public String getNomEstadi() {
        return nomEstadi;
    }

    public String getAnyFundacio() {
        return anyFundacio;
    }

    public String getCiutat() {
        return ciutat;
    }

    public HashSet<Integer> getDorsalsUsats() {
        return dorsalsUsats;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setPresesident(String newPresident){
        this.president = newPresident;
    }

    public void removeTrainer(){
        this.trainer = null;
    }

    public boolean isDorsalUsed(Integer dorsal){
        return this.dorsalsUsats.contains(dorsal);
    }

    public void addPlayer(Player player){
        this.dorsalsUsats.add(player.getDorsal());
        this.players.add(player);
    }

    public ArrayList<String> getPlayersNames(){
        return null;
    }

    public double calcularAveragePuntuationOfPlayers(){
        return 1;
    }

    public double calculateAverageMotivation(){
        return 0;
    }

    @Override
    public String toString() {
        return "Team{" +
                "president='" + president + '\'' +
                ", nomEstadi='" + nomEstadi + '\'' +
                ", name='" + name + '\'' +
                ", anyFundacio='" + anyFundacio + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", dorsalsUsats=" + dorsalsUsats +
                ", players=" + players +
                ", trainer=" + trainer +
                '}';
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Team(String name, String ciutat, String anyFundacio) {
        this.name = name;
        this.anyFundacio = anyFundacio;
        this.ciutat = ciutat;
        addEquipExists(name);
        constructorCommonActions();
    }

    public Team(String name, String ciutat, String anyFundacio, String dynamicValue, int constructorType) {
        this.name = name;
        this.anyFundacio = anyFundacio;
        this.ciutat = ciutat;

        if (constructorType == 1){
            this.nomEstadi = dynamicValue;
        }else if (constructorType == 2){
            this.president = dynamicValue;
        }
        addEquipExists(name);
        constructorCommonActions();
    }

    public Team(String president, String nomEstadi, String name, String ciutat, String anyFundacio) {
        this.president = president;
        this.nomEstadi = nomEstadi;
        this.name = name;
        this.anyFundacio = anyFundacio;
        this.ciutat = ciutat;
        addEquipExists(name);
        constructorCommonActions();
    }

    private void constructorCommonActions(){
        this.dorsalsUsats = new HashSet<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name);
    }
}
