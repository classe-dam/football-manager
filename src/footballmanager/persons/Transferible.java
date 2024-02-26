package footballmanager.persons;

import footballmanager.teams.Team;

public interface Transferible {
    public boolean esTransferible();
    public void transferirAEquip(Team e);
    public void transferirAEquip(Team team,int dorsal);
}
